package com.franconeta.ferreteria.exception;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class ExceptionResponseDTO {
     private LocalDateTime timestamp;
     private int status;
     private String error;
     private String message;
}
