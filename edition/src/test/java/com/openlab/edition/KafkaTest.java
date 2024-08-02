package com.openlab.edition;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.deser.std.StringDeserializer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
//@EmbeddedKafka(partitions = 1, topics = { "test-topic" })
public class KafkaTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public static KafkaContainer kafka = new KafkaContainer();
    private static final String TOPIC = "test-topic";

    @BeforeAll
    public static void setUp() {
        kafka.start();
        System.setProperty("spring.kafka.bootstrap-servers", kafka.getBootstrapServers());
    }

    @AfterAll
    public static void tearDown() {
        kafka.stop();
    }

     /*@Test
   public void testSendReceive() {
        String message = "Hello Kafka";
        kafkaTemplate.send("test-topic", message);

        // Utilisation de KafkaTestUtils pour consommer le message
        String receivedMessage = KafkaTestUtils.getSingleRecord(consumer, "test-topic").value();
        assertThat(receivedMessage).isEqualTo(message);
    }*/






    @Test
    void testMessageConsumption() {
        String expectedMessage = "expected-message";

        // Sending message to Kafka topic
        kafkaTemplate.send(new ProducerRecord<>(TOPIC, expectedMessage));

        // Consumer properties
        Map<String, Object> consumerProps = new HashMap<>();
        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafka.getBootstrapServers());
        consumerProps.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        try (Consumer<String, String> consumer = new KafkaConsumer<>(consumerProps)) {
            consumer.subscribe(List.of(TOPIC));

            ConsumerRecord<String, String> record = KafkaTestUtils.getSingleRecord(consumer, TOPIC);
            assertThat(record).isNotNull();

            String receivedMessage = record.value();
            assertThat(receivedMessage).isEqualTo(expectedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
}
