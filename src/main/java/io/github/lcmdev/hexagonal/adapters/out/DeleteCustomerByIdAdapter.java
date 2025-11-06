package io.github.lcmdev.hexagonal.adapters.out;

import io.github.lcmdev.hexagonal.adapters.out.repository.CustomerRepository;
import io.github.lcmdev.hexagonal.application.ports.out.DeleteCustomerByIdOuputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOuputPort {

  private final CustomerRepository customerRepository;

  @Override
  public void delete(String id) {
    customerRepository.deleteById(id);
  }
}
