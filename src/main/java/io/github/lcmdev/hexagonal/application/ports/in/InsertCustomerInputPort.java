package io.github.lcmdev.hexagonal.application.ports.in;

import io.github.lcmdev.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

  void insert(Customer customer, String zipCode);
}