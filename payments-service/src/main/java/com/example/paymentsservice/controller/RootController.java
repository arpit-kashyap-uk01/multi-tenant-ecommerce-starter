package com.example.paymentsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
  @GetMapping("/ping")
  public String ping() { return "payments-service OK"; }
}
