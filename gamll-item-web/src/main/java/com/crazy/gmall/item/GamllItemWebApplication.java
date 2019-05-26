package com.crazy.gmall.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.crazy.gmall")
public class GamllItemWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(GamllItemWebApplication.class, args);
  }

}
