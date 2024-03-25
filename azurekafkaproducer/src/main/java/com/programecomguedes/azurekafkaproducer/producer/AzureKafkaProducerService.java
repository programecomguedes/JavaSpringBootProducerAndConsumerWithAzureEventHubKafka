package com.programecomguedes.azurekafkaproducer.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@Slf4j
public class AzureKafkaProducerService {
    @Value("${spring.kafka.producer.topic-name}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public AzureKafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        try {
            kafkaTemplate.send(topicName, message).get();
            log.info("Mensagem enviada: {}", message);
        } catch (InterruptedException | ExecutionException e) {
            log.error("Erro ao enviar mensagem", e);
        }
    }
}
