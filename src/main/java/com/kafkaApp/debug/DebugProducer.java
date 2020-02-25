package com.kafkaApp.debug;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DebugProducer {
    public void run(){
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(1000);

        int counter=0;
        // create a kafka producer
        KafkaProducer<String, String> producer = createKafkaProducer();
        while (true) {
            UUID uuid = UUID.randomUUID();
            msgQueue.add("Adam Debug Info("+(counter++)+"):"+uuid.toString());
            producer.send(new ProducerRecord<>("twitter_tweets1",null, msgQueue.poll()));
        }

    }

    public KafkaProducer<String, String> createKafkaProducer(){
        String bootstrapServers = "127.0.0.1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        return producer;
    }
}
