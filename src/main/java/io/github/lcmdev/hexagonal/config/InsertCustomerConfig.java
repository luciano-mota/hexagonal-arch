package io.github.lcmdev.hexagonal.config;

import io.github.lcmdev.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import io.github.lcmdev.hexagonal.adapters.out.InsertCustomerAdapter;
import io.github.lcmdev.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

  @Bean
  public InsertCustomerUseCase insertCustomerUseCase(
      FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
      InsertCustomerAdapter insertCustomerAdapter) {
    return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
  }
}