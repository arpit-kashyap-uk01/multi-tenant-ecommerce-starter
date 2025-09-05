package com.example.fileservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
  @GetMapping("/ping")
  public String ping() { return "file-service OK"; }
}
