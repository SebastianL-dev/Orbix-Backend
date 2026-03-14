package co.edu.uptc.orbix_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class GreetController {
  @GetMapping("")
  public String getMethodName() {
    return "Hola mundo!";
  }
}
