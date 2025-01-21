package com.project.searchservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.project.searchservice.documents.UserEntityDocument;
import com.project.searchservice.dtos.UserEntityDTO;
import com.project.searchservice.repositories.UserEntityDocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchUserEntityDocumentService {
    private final ObjectMapper objectMapper;
    private final UserEntityDocRepository userEntityDocRepository;

    public void syncUserEntity(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            String operation = jsonNode.get("payload").get("op").asText();
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
            switch (operation) {
                case "u": {
                    JsonNode after = jsonNode.get("payload").get("after");
                    System.out.println("Syncing update operation...");
                    UserEntityDTO userEntityDTO = objectMapper.treeToValue(after, UserEntityDTO.class);
                    UserEntityDocument userEntityDocument = userEntityDTO.toDocument();
                    System.out.println(userEntityDocument);
                    userEntityDocRepository.save(userEntityDocument);
                    break;
                }
                case "c": {
                    JsonNode after = jsonNode.get("payload").get("after");
                    System.out.println("Syncing create operation...");
                    UserEntityDTO userEntityDTO = objectMapper.treeToValue(after, UserEntityDTO.class);
                    UserEntityDocument userEntityDocument = userEntityDTO.toDocument();
                    System.out.println(userEntityDocument);
                    userEntityDocRepository.save(userEntityDocument);
                    break;
                }
                case "d": {
                    JsonNode before = jsonNode.get("payload").get("before");
                    System.out.println("Syncing delete operation...");
                    UserEntityDTO userEntityDTO = objectMapper.treeToValue(before, UserEntityDTO.class);
                    userEntityDocRepository.deleteById(userEntityDTO.getUserEntityId());
                    break;
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
