package com.frauddetection.service.controller;

import com.frauddetection.service.model.TransactionEvent;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Transaction Service is running";
    }

    @PostMapping("/send")
    public String processTransaction(@RequestBody TransactionEvent event) {
        // Transaction processing logic will go here
        return "Transaction " + event.getTransactionId() + " received";
    }
}
