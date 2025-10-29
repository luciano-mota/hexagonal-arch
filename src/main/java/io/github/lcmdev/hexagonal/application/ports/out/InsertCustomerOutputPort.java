package io.github.lcmdev.hexagonal.application.ports.out;

import io.github.lcmdev.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

  void insert(Customer customer);
}