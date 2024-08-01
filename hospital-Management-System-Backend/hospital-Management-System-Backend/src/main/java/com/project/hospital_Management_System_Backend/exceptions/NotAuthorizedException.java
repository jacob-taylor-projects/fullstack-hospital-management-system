package com.project.hospital_Management_System_Backend.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotAuthorizedException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1324866893531848107L;

    private String message;

}
