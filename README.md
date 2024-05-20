# Java Spring Boot with Apache Kafka local and Azure Event Hubs for Apache Kafka
Two simple projects to send and receive messages to Apache Kafka and Azure Event Hubs for Kafka.

# Execute local Apache Kafka
If do not have a Apache Kafka running in local machine, execute the following command:
```bash
docker compose -f docker-compose-kafka-only.yml up -d 
```

## Execute from IDLE
## Run with local Apache Kafka
For Producer application, creates the following environment variables:
```
- SPRING_PROFILES_ACTIVE=local
- KAFKA_BOOTSTRAP_SERVERS=localhost:9092
- KAFKA_TOPIC_NAME={TOPIC_NAME}
```

For Consumer application, creates the following environment variables:
```
- SPRING_PROFILES_ACTIVE=local
- KAFKA_BOOTSTRAP_SERVERS=localhost:9092
- KAFKA_TOPIC_NAME={TOPIC_NAME}
- GROUP_ID={GROUP_ID_NAME}
```

Note: Change {TOPIC_NAME} and {GROUP_ID_NAME} for your Kafka configurations.

## Run with Event Hub for Apache Kafka
For Producer application, creates the following environment variables:
```
- SPRING_PROFILES_ACTIVE=prd
- KAFKA_BOOTSTRAP_SERVERS={EVENT_HUB_NAMESPACE}.servicebus.windows.net:9093
- KAFKA_SASL_JAAS_CONFIG=org.apache.kafka.common.security.plain.PlainLoginModule required username="\$\ConnectionString" password="{EVENT_HUB_CONNECTION_STRING}";
- KAFKA_TOPIC_NAME={TOPIC_NAME}
```

For Consumer application, creates the following environment variables:
```
- SPRING_PROFILES_ACTIVE=prd
- KAFKA_BOOTSTRAP_SERVERS={EVENT_HUB_NAMESPACE}.servicebus.windows.net:9093
- KAFKA_SASL_JAAS_CONFIG=org.apache.kafka.common.security.plain.PlainLoginModule required username="\$\ConnectionString" password="{EVENT_HUB_CONNECTION_STRING}";
- KAFKA_TOPIC_NAME={TOPIC_NAME}
- GROUP_ID={GROUP_ID_NAME}
```

Note 1: Change {EVENT_HUB_NAMESPACE}, {EVENT_HUB_CONNECTION_STRING}, {TOPIC_NAME} and {GROUP_ID_NAME} to your informations.
Note 2: For Event Hub for Apacha Kafka GROUP_ID it is the same as CONSUMER_GROUP_ID

# Run with Docker Compose file
## To local Apache Kafka
First, open the `docker-compose-local.yml` file and change {TOPIC_NAME} and {GROUP_ID_NAME} to your local Apache Kafka configurations.

After, execute the following command:
```bash
docker-compose -f docker-compose-local.yml up
```

## To Event Hub for Apache Kafka
First, open the `docker-compose-prd.yml` file and change {EVENT_HUB_NAMESPACE}, {EVENT_HUB_CONNECTION_STRING}, {TOPIC_NAME} and {GROUP_ID_NAME} to your Event Hub Apache for Kafka configurations.

After, execute the following command:
```bash
docker-compose -f docker-compose-prd.yml up
```

# Set Environment Variable on WSL (optional)
This session is optional if to run from WSL.
Open the .bashrc file
```bash
nano ~/.bashrc
```
Add the following lines and save the file:
```
export ConnectionString='$ConnectionString'
export KAFKA_BOOTSTRAP_SERVERS={AZURE_EVENT_HUB_NAMESPACE_NAME_HERE}.servicebus.windows.net:9093
export KAFKA_SASL_JAAS_CONFIG=org.apache.kafka.common.security.plain.PlainLoginModule required username="$ConnectionString" password="{AZURE_EVENT_HUB_CONNECTION_STRING_HERE}";
```
Note: Change `{AZURE_EVENT_HUB_NAMESPACE_NAME_HERE}` and `{AZURE_EVENT_HUB_CONNECTION_STRING_HERE}` to your Azure Event Hub namespace name and Azure Event Hubs connection string respectively.

Update your environemtn variables:
```bash
source ~/.bashrc
```

Execute the following command:
```bash
docker-compose -f docker-compose-wsl.yml up
```

# Docker Hub Images
Producer:
- https://hub.docker.com/r/programecomguedes/javaspringboot-azureeventhub-kafkaproducer

Consumer:
- https://hub.docker.com/r/programecomguedes/javaspringboot-azureeventhub-kafkaconsumer
