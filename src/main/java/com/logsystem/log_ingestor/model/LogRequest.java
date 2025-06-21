package com.logsystem.log_ingestor.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.logsystem.log_ingestor.validation.ValidLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class LogRequest {

    @NotBlank(message = "service name cannot be empty")
    private String service;

    @NotBlank(message = "service id cannot be empty")
    private String service_id;

    @ValidLevel
    private String logLevel;

    @NotBlank(message = "message cannot be empty")
    private String message;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime timeStamp;
    
}
