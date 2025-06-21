package com.logsystem.log_ingestor.model;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String serviceName;
    private String password;
}
