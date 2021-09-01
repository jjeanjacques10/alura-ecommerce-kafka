package br.com.alura.ecommerce.consumer;

import br.com.alura.ecommerce.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public interface ConsumerService<T> {

     // you may argue that a ConsumerException would be better
     // and its ok, it can be better
     void parse(ConsumerRecord<String, Message<T>> record) throws IOException, ExecutionException, InterruptedException, SQLException;
     String getTopic();
     String getConsumerGroup();
}
