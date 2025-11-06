package io.github.lcmdev.hexagonal.application.ports.in;

import io.github.lcmdev.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

  void update(Customer customer, String zipCode);
}
