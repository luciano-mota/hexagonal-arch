package io.github.lcmdev.hexagonal.config;

import io.github.lcmdev.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import io.github.lcmdev.hexagonal.adapters.out.UpdateCustomerAdapter;
import io.github.lcmdev.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import io.github.lcmdev.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

  @Bean
  public UpdateCustomerUseCase updateCustomerUseCase(
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
      UpdateCustomerAdapter updateCustomerAdapter
  ) {
    return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
  }
}