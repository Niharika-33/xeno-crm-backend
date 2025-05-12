package com.xeno.crm.controller;

import com.xeno.crm.model.Campaign;
import com.xeno.crm.model.CommunicationLog;
import com.xeno.crm.model.Customer;
import com.xeno.crm.service.CampaignService;
import com.xeno.crm.service.CommunicationLogService;
import com.xeno.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CommunicationLogService communicationLogService;

    private final Random random = new Random();

    @PostMapping
    public Campaign createCampaign(@RequestBody Campaign campaign) {
        Campaign savedCampaign = campaignService.createCampaign(campaign);

        List<Customer> allCustomers = customerService.getAllCustomers(); // Simplified logic

        for (Customer customer : allCustomers) {
            String message = "Hi " + customer.getName() + ", here's 10% off on your next order!";
            String status = random.nextDouble() < 0.9 ? "SENT" : "FAILED";

            CommunicationLog log = new CommunicationLog();
            log.setCustomerId(customer.getId());
            log.setCampaignId(savedCampaign.getId());
            log.setMessage(message);
            log.setDeliveryStatus(status);

            communicationLogService.saveLog(log);
        }

        return savedCampaign;
    }

    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}/logs")
    public List<CommunicationLog> getCampaignLogs(@PathVariable Long id) {
        return communicationLogService.getLogsByCampaignId(id);
    }
}
