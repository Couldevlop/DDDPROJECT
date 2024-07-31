package com.openlab.edition.infras.messaging;

import com.openlab.edition.domaine.event.ContenuValidatedEvent;
import com.openlab.edition.infras.ContenuSubmittedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishContenuSubmittedEvent(ContenuSubmittedEvent event) {
        kafkaTemplate.send("contenuSubmitted", event);
    }

    public void publishContenuValidatedEvent(ContenuValidatedEvent event) {
        kafkaTemplate.send("contenuValidated", event);
    }
}


