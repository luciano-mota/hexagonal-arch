package io.github.lcmdev.hexagonal.config;

import io.github.lcmdev.hexagonal.adapters.out.FindCustomerByIdAdapter;
import io.github.lcmdev.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

  @Bean
  public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
    return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
  }
}