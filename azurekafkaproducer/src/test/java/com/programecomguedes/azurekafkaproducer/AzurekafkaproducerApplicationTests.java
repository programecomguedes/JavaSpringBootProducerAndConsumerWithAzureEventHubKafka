package com.programecomguedes.azurekafkaproducer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
@TestPropertySource(properties = {
		"KAFKA_BOOTSTRAP_SERVERS=namespace_name.servicebus.windows.net:9093",
		"KAFKA_SASL_JAAS_CONFIG=org.apache.kafka.common.security.plain.PlainLoginModule required username=\"$ConnectionString\" password=\"connection_string\";"
})
class AzurekafkaproducerApplicationTests {

	@Test
	void contextLoads() {
	}

}
