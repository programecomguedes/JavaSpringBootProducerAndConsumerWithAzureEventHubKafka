package com.programecomguedes.azurekafkaproducer.controller;

import com.programecomguedes.azurekafkaproducer.producer.AzureKafkaProducerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.programecomguedes.azurekafkaproducer.controller.KafkaMessageController;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class KafkaMessageControllerTest {
    @Mock
    private AzureKafkaProducerService azureKafkaProducerService;

    @InjectMocks
    private KafkaMessageController kafkaMessageController;

    @Test
    void sendMessageTest() {
        final String body = "{\"hello\":\"world!\"}";
        final int count = 5;

        kafkaMessageController.sendMessage(count, body);

        verify(azureKafkaProducerService, times(count)).sendMessage(body);
    }
}
