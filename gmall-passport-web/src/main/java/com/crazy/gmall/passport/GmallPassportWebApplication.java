package com.crazy.gmall.passport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.crazy.gmall")
public class GmallPassportWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(GmallPassportWebApplication.class, args);
  }

}
