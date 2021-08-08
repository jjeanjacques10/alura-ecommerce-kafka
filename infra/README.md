# Infraestrutura Kafka

Caso não queira instalar o Kafka em sua máquina você pode utilizar o Docker.

## Imagens

- Zookeeper
- Kafka
- Kafdrop (Auxilia para visualizar os tópicos)

## Get Start
Rode o arquivo [start.sh](start.sh)

``` shell
sh start.sh

# ou

./start.sh
```

## Comandos

Lembrando que para rodar os comandos nos containers é preciso fazer desta forma:

``` shell
docker-compose exec kafka [seu-comando-aqui]
```