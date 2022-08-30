package com.example.kafkaproject;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.Closeable;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@SpringBootApplication
public class KafkaProjectApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaProjectApplication.class, args);

        KafkaProducer<String, String> producer = context.getBean(KafkaProducer.class);

        ProducerRecord<String, String> record = new ProducerRecord<>("test", "Precision Products", "France");
        try {
            producer.send(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

//        String topic = "spring-kafka-demo";
//        MyProducer producer = new MyProducer(topic);
//
//        int messages = 10000;
//        CountDownLatch launch = new CountDownLatch(messages);
//        ExecutorService pool = Executors.newFixedThreadPool(100);
//
//
//        for (int i = 0; i < messages; i++) {
//            try {
//                producer.send(String.valueOf(i), "Hello from MyProducer");
//                launch.countDown();
//            } catch (ExecutionException | InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        launch.await();
//
//
//
//        MyConsumer consumer = new MyConsumer(topic);
//        consumer.consume(new Consumer<ConsumerRecord<String, String>>() {
//            @Override
//            public void accept(ConsumerRecord<String, String> record) {
//                System.out.println("Got key: " + record.key() + ", value: " + record.value());
//            }
//        });
//
//        producer.close();
//        Thread.sleep(30000);
//        consumer.close();
//    }

}

//class MyConsumer implements Closeable {
//
//    KafkaConsumer<String, String> consumer = getConsumer();
//
//    String topic;
//
//    public MyConsumer(String topic) {
//        this.topic = topic;
//    }
//
//    private KafkaConsumer<String, String> getConsumer() {
//        Properties properties = new Properties();
//        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "groupId");
//        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
//        consumer.subscribe(Collections.singletonList("spring-kafka-demo"));
//        return consumer;
//    }
//
//    public void consume(Consumer<ConsumerRecord<String, String>> recordConsumer) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
//                    records.forEach(recordConsumer::accept);
//                }
//            }
//        }).start();
//    }
//
//    @Override
//    public void close() throws IOException {
//        consumer.close();
//    }
//}
//
//class MyProducer implements Closeable {
//
//    KafkaProducer<String, String> producer = getProducer();
//    String topic;
//
//    public MyProducer(String topic) {
//        this.topic = topic;
//    }
//
//    private KafkaProducer<String, String> getProducer() {
//        Properties properties = new Properties();
//        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        properties.setProperty(ProducerConfig.CLIENT_ID_CONFIG, "clientId");
//        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//        return new KafkaProducer<>(properties);
//    }
//
//    public void send(String key, String value) throws ExecutionException, InterruptedException {
//        producer.send(new ProducerRecord<>(topic, key, value))
//                .get();
//    }
//
//    @Override
//    public void close() throws IOException {
//        producer.flush();
//        producer.close();
//    }
}
