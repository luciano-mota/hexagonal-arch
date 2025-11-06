package io.github.lcmdev.hexagonal.adapters.out;

import io.github.lcmdev.hexagonal.adapters.out.repository.CustomerRepository;
import io.github.lcmdev.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import io.github.lcmdev.hexagonal.application.core.domain.Customer;
import io.github.lcmdev.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

  private final CustomerRepository customerRepository;
  private final CustomerEntityMapper customerEntityMapper;

  @Override
  public void update(Customer customer) {
    var customerEntity = customerEntityMapper.toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}