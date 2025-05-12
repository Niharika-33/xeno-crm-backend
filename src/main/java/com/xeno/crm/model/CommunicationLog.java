package com.xeno.crm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunicationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long campaignId;
    private Long customerId;
    private String message;
    private String status; // SENT or FAILED
    private String sentAt;

    // Lombok will automatically generate the setter methods, but just in case:
    public void setDeliveryStatus(String status) {
        this.status = status;
    }
}
