package com.example.gatewayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
  @GetMapping("/ping")
  public String ping() { return "gateway-service OK"; }
}
