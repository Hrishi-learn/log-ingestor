package com.logsystem.log_ingestor.service;

import com.logsystem.log_ingestor.model.LogRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private KafkaTemplate<String, LogRequest> kafkaTemplate;
    private final String TopicName = "raw-logs";

    public KafkaProducerService(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLogs(LogRequest logRequest){
        kafkaTemplate.send(TopicName,logRequest);
    }
}
