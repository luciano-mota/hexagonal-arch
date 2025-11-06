package io.github.lcmdev.hexagonal.adapters.out;

import io.github.lcmdev.hexagonal.adapters.out.repository.CustomerRepository;
import io.github.lcmdev.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import io.github.lcmdev.hexagonal.application.core.domain.Customer;
import io.github.lcmdev.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

  private final CustomerRepository customerRepository;
  private final CustomerEntityMapper customerEntityMapper;

  @Override
  public Optional<Customer> find(String id) {
    var customerEntity = customerRepository.findById(id);
    return customerEntity.map(customerEntityMapper::toCustomer);
  }
}
