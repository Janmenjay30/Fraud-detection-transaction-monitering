package com.frauddetection.service.service;

import com.frauddetection.service.model.TransactionEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class FraudConsumer {

    @KafkaListener(topics = "transactions-topic", groupId = "fraud-group")
    public void consume(TransactionEvent event) {

        System.out.println("Received Transaction: " + event);

        boolean isFraud = checkFraud(event);

        if (isFraud) {
            System.out.println("🚨 FRAUD DETECTED: "
                    + event.getTransactionId());
        } else {
            System.out.println("✅ CLEAN: "
                    + event.getTransactionId());
        }
    }

    private boolean checkFraud(TransactionEvent e) {

        // RULE 1 – High Amount
        if (e.getAmount() > 50000)
            return true;

        return false;
    }
}
