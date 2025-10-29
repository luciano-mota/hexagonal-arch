package io.github.lcmdev.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HexagonalArchApplication {

  public static void main(String[] args) {
    SpringApplication.run(HexagonalArchApplication.class, args);
  }

}