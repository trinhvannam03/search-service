package com.project.searchservice.services;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaListeners {
    private final SearchUserEntityDocumentService userEntityDocumentService;

    @KafkaListener(topics = {"user_service.user_service.user_entity"}, containerFactory = "userCdcContainerFactory")
    public void syncUserEntity(ConsumerRecord<String, String> record) {
        userEntityDocumentService.syncUserEntity(record.value());
    }
}
