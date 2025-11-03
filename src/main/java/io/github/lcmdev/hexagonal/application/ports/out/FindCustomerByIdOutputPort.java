package io.github.lcmdev.hexagonal.application.ports.out;

import io.github.lcmdev.hexagonal.application.core.domain.Customer;
import java.util.Optional;

public interface FindCustomerByIdOutputPort {

  Optional<Customer> find(String id);
}