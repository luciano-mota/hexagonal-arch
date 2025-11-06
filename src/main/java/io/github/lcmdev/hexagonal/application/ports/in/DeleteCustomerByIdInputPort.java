package io.github.lcmdev.hexagonal.application.ports.in;

public interface DeleteCustomerByIdInputPort {

  void delete(String id);
}