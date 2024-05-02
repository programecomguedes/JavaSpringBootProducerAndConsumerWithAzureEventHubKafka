package com.programecomguedes.azurekafkaproducer.controller;

import com.programecomguedes.azurekafkaproducer.producer.AzureKafkaProducerService;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@Slf4j
public class KafkaMessageController {

    final private AzureKafkaProducerService azureKafkaProducerService;

    @Autowired
    public KafkaMessageController(AzureKafkaProducerService azureKafkaProducerService) {
        this.azureKafkaProducerService = azureKafkaProducerService;
    }

    @PostMapping("/send")
    @Parameter(name = "count", description = "Number of messages to send", example = "1")
    public void sendMessage(@RequestHeader("count") Integer count, final @RequestBody String body) {
        if (Objects.isNull(count)) {
            count = 1;
        }

        for (int i = 1; i <= count; i++) {
            azureKafkaProducerService.sendMessage(body);
        }

        ResponseEntity.ok().build();
    }
}
