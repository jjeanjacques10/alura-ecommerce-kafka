package br.com.alura.ecommerce;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaDispatcher<T> implements Closeable {
    private final KafkaProducer<String, Message<T>> producer;

    KafkaDispatcher() {
        this.producer = new KafkaProducer<>(properties());
    }

    private static Properties properties() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all"); // Leader will wait all broker get message

        return properties;
    }

    public void send(String topic, String key, CorrelationId correlationId, T payload) throws ExecutionException, InterruptedException {
        Future<RecordMetadata> future = sendAsync(topic, key, correlationId, payload);
        future.get();
    }

    Future<RecordMetadata> sendAsync(String topic, String key, CorrelationId correlationId, T payload) {
        var value = new Message<T>(correlationId, payload);
        var record = new ProducerRecord<>(topic, key, value);

        Callback callback = (data, exception) -> {
            if (exception != null) {
                return;
            }
            System.out.println(data.topic() + ":::partition " + data.partition() + "/ offset: " + data.offset() + "/ timestamp: " + data.timestamp());
        };

        var future = producer.send(record, callback);
        return future;
    }

    @Override
    public void close() {
        producer.close();
    }
}
