package com.example.emailServiceForEco.controller;

import com.example.emailServiceForEco.model.EmailModel;
import com.example.emailServiceForEco.service.DefaultEmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class EmailController {
    DefaultEmailService defaultEmailService;

    @PostMapping("/model")
    public ResponseEntity<String> handleJsonRequest(@RequestBody EmailModel jsonModel) {
        String email = jsonModel.getEmail();
        String sub = jsonModel.getSubject();
        String message = jsonModel.getMessage();

        defaultEmailService.sendSimpleEmail(jsonModel.getEmail(), jsonModel.getSubject(),jsonModel.getMessage());

        String response = "Received JSON: " + jsonModel.toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/+")
    public String get(){
        return "Hello";
    }
}
