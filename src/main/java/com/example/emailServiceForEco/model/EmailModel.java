package com.example.emailServiceForEco.model;

import lombok.Data;

@Data
public class EmailModel {
    private String email;
    private String subject;
    private String message;
}
