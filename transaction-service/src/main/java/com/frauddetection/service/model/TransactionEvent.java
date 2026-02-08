package com.frauddetection.service.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEvent {

    private String transactionId;
    private String userId;
    private Double amount;
    private String location;
    private String deviceId;
    private Long timestamp;
}
