package com.xeno.crm.service;

import com.xeno.crm.model.CommunicationLog;
import com.xeno.crm.repository.CommunicationLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationLogService {

    @Autowired
    private CommunicationLogRepository communicationLogRepository;

    public CommunicationLog saveLog(CommunicationLog log) {
        return communicationLogRepository.save(log);
    }

    public List<CommunicationLog> getLogsByCampaignId(Long campaignId) {
        return communicationLogRepository.findByCampaignId(campaignId);
    }

    public CommunicationLog updateDeliveryStatus(Long logId, String status) {
        CommunicationLog log = communicationLogRepository.findById(logId).orElse(null);
        if (log != null) {
            log.setDeliveryStatus(status);
            return communicationLogRepository.save(log);
        }
        return null;
    }
}
