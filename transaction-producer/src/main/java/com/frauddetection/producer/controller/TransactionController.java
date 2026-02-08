package com.frauddetection.producer.controller;

import com.frauddetection.producer.model.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private KafkaTemplate<String, TransactionEvent> kafkaTemplate;

    @GetMapping("/health")
    public String healthCheck() {
        return "Application is running";
    }

    @PostMapping
    public String publish(@RequestBody TransactionEvent event) {

        kafkaTemplate.send(
            "transactions-topic",
            event.getTransactionId(),
            event
        );

        return "Event Sent to Kafka";
    }
}
