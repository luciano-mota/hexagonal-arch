package io.github.lcmdev.hexagonal.application.core.usecase;

import io.github.lcmdev.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import io.github.lcmdev.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import io.github.lcmdev.hexagonal.application.ports.out.DeleteCustomerByIdOuputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final DeleteCustomerByIdOuputPort deleteCustomerByIdOuputPort;

  public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
      DeleteCustomerByIdOuputPort deleteCustomerByIdOuputPort) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.deleteCustomerByIdOuputPort = deleteCustomerByIdOuputPort;
  }

  @Override
  public void delete(String id) {
    findCustomerByIdInputPort.find(id);
    deleteCustomerByIdOuputPort.delete(id);
  }
}