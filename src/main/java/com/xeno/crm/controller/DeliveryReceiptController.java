package com.xeno.crm.controller;

import com.xeno.crm.model.CommunicationLog;
import com.xeno.crm.service.CommunicationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryReceiptController {

    @Autowired
    private CommunicationLogService communicationLogService;

    @PostMapping("/receipt")
    public CommunicationLog updateDeliveryStatus(@RequestParam Long logId, @RequestParam String status) {
        return communicationLogService.updateDeliveryStatus(logId, status);
    }
}

