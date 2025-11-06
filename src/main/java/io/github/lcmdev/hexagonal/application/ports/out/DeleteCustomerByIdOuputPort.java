package io.github.lcmdev.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOuputPort {

  void delete(String id);
}