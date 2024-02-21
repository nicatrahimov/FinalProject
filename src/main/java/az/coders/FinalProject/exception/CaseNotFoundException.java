package az.coders.FinalProject.exception;

import jakarta.validation.constraints.NotBlank;

public class CaseNotFoundException extends RuntimeException {

    public CaseNotFoundException(String message) {
        super(message);
    }
}
