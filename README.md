# Ecommerce Kafka - Alura

Aplicação desenvolvida na formação Kafka da Alura

- [Curso de Kafka: Produtores, Consumidores e streams](https://cursos.alura.com.br/course/kafka-introducao-a-streams-em-microservicos)

## Tecnologias

- Kafka
- Java

## Módulos

### [Commom Kafka](./commom-kafka)
- Arquivos base para utilizar o Kafka
### [Service Email](./service-email)
- Serviço que lê o tópico de e-mail
### [Service Fraud Detector](./service-fraud-detector)
- Serviço que lê o tópico de new-order
### [Service Log](./service-log)
- Serviço que gera os logs lendo todos os tópicos gerados para ecommerce
### [Service New Order](./service-new-order)
- Serviço de criação de tópicos (new-order e e-mail)

## Anotações

**Start kafka server**

```bash
./bin/kafka-server-start.sh config/server.properties
```

> O zookeeper é utilizado para armazenar as mensagens do Kafka, por essa razão é necessário baixa-lo.

**Start zookeeper**

```bash
./bin/zookeeper-server-start.sh config/zookeeper.properties
```

**Create a new topic**

```bash
./bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic LOJA_NOVOPEDIDO
```

**List topics created**

```bash
./bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

**Insert messages in topic**

```bash
./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic LOJA_NOVOPEDIDO
```

If you want to get from the first message to last, use: --from-beginning

**Read message from topic**

```bash
./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ECOMMERCE_NEW_ORDER --from-beginning
```