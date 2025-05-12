package com.xeno.crm.repository;

import com.xeno.crm.model.CommunicationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunicationLogRepository extends JpaRepository<CommunicationLog, Long> {
    List<CommunicationLog> findByCampaignId(Long campaignId);
}
