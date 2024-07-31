package com.openlab.edition.infras.messaging;

import com.openlab.edition.domaine.event.ContenuValidatedEvent;
import com.openlab.edition.infras.ContenuSubmittedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "contenuSubmitted", groupId = "group_id")
    public void consumeContenuSubmittedEvent(ContenuSubmittedEvent event) {
        // Process the event
    }

    @KafkaListener(topics = "contenuValidated", groupId = "group_id")
    public void consumeContenuValidatedEvent(ContenuValidatedEvent event) {
        // Process the event
    }
}