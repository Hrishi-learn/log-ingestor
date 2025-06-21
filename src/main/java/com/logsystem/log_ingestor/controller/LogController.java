package com.logsystem.log_ingestor.controller;


import com.logsystem.log_ingestor.model.LogRequest;
import com.logsystem.log_ingestor.service.KafkaProducerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    private KafkaProducerService kafkaProducerService;
    public LogController(KafkaProducerService kafkaProducerService){
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/")
    public ResponseEntity<String>ingestLogs(@Valid @RequestBody LogRequest logRequest){
        kafkaProducerService.sendLogs(logRequest);
        return ResponseEntity.ok("Log received");
    }

}
