package com.project.hospital_Management_System_Backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends RuntimeException{
    @Serial
    private static final long serialVersionUID= -4272133873932632850L;

    private String message;
}