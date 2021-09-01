# Ecommerce Kafka - Alura

Aplicação desenvolvida na formação Kafka da Alura

- [Curso de Kafka: Produtores, Consumidores e streams](https://cursos.alura.com.br/course/kafka-introducao-a-streams-em-microservicos)
- [Kafka: Fast delegate, evolução e cluster de brokers](https://cursos.alura.com.br/course/kafka-cluster-de-microservicos)
- [Kafka: Batches, correlation ids e dead letters](https://cursos.alura.com.br/course/kafka-batches-correlation-ids-e-dead-letters)
- [Kafka: Idempotência e garantias](https://cursos.alura.com.br/course/kafka-idempotencia-e-garantias)

## Tecnologias

- Kafka
- Java
- SQLite

## Módulos

- [Commom Kafka](./commom-kafka)
    - Módulo base para utilizar o Kafka
- [Commom Database](./commom-database)
    - Módulo para utilizar o banco de dados SQLite
- [Service Email](./service-email)
    - Serviço que lê o tópico de e-mail
- [Service Email New Order](./service-email)
  - Serviço que lê o tópico de e-mail e faz o direcionamento para o [Service Email](./service-email)
- [Service Fraud Detector](./service-fraud-detector)
    - Serviço que lê o tópico de new-order e verifica se o pedido é uma fraude
- [Service Log](./service-log)
    - Serviço que gera os logs lendo todos os tópicos gerados para ecommerce
- [Service New Order](./service-new-order)
    - Serviço de criação de tópicos (new-order e e-mail)
- [Service Users](./service-users)
    - Serviço para criação de um usuário usuário no banco de dados (SQLite)
- [Service HTTP Ecommerce](./service-http-ecommerce)
    - Serviço o envio de Orders por requisições HTTP
- [Service Reading Report](./service-reading-report)
    - Serviço que faz o envio de relatórios para todos os usuários

#### Exemplo de chamada no Serviço HTTP

```
http://localhost:8080/new?email=jjean.jacques10@gmail.com&amount=1999&uuid=f76ec663-acdc-4ba3-8c5f-f827e006abdf
```

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

---
Developed by Jean Jacques