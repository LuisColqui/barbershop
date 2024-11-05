package com.example.barbershop.exception;

import java.time.LocalDateTime;
public record CustomErrorResponse(
    LocalDateTime timestamp,
    String message,
    String path
) {

}
