# Java Spring Boot Producer and Consumer with Azure Event Hubs Kafka
Two simple projects to send and receive messages from Azure Event Hubs with Kafka enabled.

# Requirements
If you are running the `docker run` command or some IDLE (e.g: IntelliJ IDEA), you need to create the following environment variables:
```
KAFKA_BOOTSTRAP_SERVERS=AZURE_EVENT_HUB_NAMESPACE_NAME_HERE.servicebus.windows.net:9093
```
and:
```
KAFKA_SASL_JAAS_CONFIG=org.apache.kafka.common.security.plain.PlainLoginModule required username="\$\ConnectionString" password="AZURE_EVENT_HUB_CONNECTION_STRING_HERE";
```
Note: Change `AZURE_EVENT_HUB_NAMESPACE_NAME_HERE` and `AZURE_EVENT_HUB_CONNECTION_STRING_HERE` to your Azure Event Hub namespace name and Azure Event Hubs connection string respectively.

# Run with Docker
## Build Producer Project
```bash
cd azurekafkaproducer
docker build -t producer .
```
## Run Producer Image
```bash
docker run -e KAFKA_BOOTSTRAP_SERVERS="$KAFKA_BOOTSTRAP_SERVERS" -e KAFKA_SASL_JAAS_CONFIG="$KAFKA_SASL_JAAS_CONFIG" -p 8081:8081 producer
```

## Build Consumer Project
```bash
cd azurekafkaconsumer
docker build -t consumer .
```
## Run Consumer Image
```bash
docker run -e KAFKA_BOOTSTRAP_SERVERS="$KAFKA_BOOTSTRAP_SERVERS" -e KAFKA_SASL_JAAS_CONFIG="$KAFKA_SASL_JAAS_CONFIG" -p 8082:8082 consumer
```

# Run with Docker Compose file
First, open the docker-compose.yml file and change AZURE_EVENT_HUB_NAMESPACE_NAME_HERE and AZURE_EVENT_HUB_CONNECTION_STRING_HERE to your Azure Event Hub namespace name and Azure Event Hubs connection string respectively.

After, execute the following command:
```bash
docker-compose up
```

# Set Environment Variable on WSL
Open the .bashrc file
```bash
nano ~/.bashrc
```
Add the following lines and save the file:
```
export ConnectionString='$ConnectionString'
export KAFKA_BOOTSTRAP_SERVERS=AZURE_EVENT_HUB_NAMESPACE_NAME_HERE.servicebus.windows.net:9093
export KAFKA_SASL_JAAS_CONFIG=org.apache.kafka.common.security.plain.PlainLoginModule required username="$ConnectionString" password="AZURE_EVENT_HUB_CONNECTION_STRING_HERE"
```
Note: Change `AZURE_EVENT_HUB_NAMESPACE_NAME_HERE` and `AZURE_EVENT_HUB_CONNECTION_STRING_HERE` to your Azure Event Hub namespace name and Azure Event Hubs connection string respectively.

Update your environemtn variables:
```bash
source ~/.bashrc
```