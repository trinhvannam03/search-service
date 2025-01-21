package com.project.searchservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaListeners {

    @KafkaListener(topics = {"keycloak.keycloak.user_entity"}, containerFactory = "userCdcContainerFactory")
    public void userCdcListener(String message) {

    }
}
