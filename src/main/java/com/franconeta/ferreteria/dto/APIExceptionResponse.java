package com.franconeta.ferreteria.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class APIExceptionResponse {
     private LocalDateTime timestamp;
     private int status;
     private String error;
     private String message;
}
