package io.github.lcmdev.hexagonal.adapters.out;

import io.github.lcmdev.hexagonal.adapters.out.repository.CustomerRepository;
import io.github.lcmdev.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import io.github.lcmdev.hexagonal.application.core.domain.Customer;
import io.github.lcmdev.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

  private final CustomerRepository customerRepository;
  private final CustomerEntityMapper customerEntityMapper;


  @Override
  public void insert(Customer customer) {
    var customerEntity = customerEntityMapper.toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}
