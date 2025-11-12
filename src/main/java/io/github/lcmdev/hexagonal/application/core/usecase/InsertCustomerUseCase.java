package io.github.lcmdev.hexagonal.application.core.usecase;

import io.github.lcmdev.hexagonal.application.core.domain.Customer;
import io.github.lcmdev.hexagonal.application.ports.in.InsertCustomerInputPort;
import io.github.lcmdev.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import io.github.lcmdev.hexagonal.application.ports.out.InsertCustomerOutputPort;
import io.github.lcmdev.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
  private final InsertCustomerOutputPort insertCustomerOutputPort;
  private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

  public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
      InsertCustomerOutputPort insertCustomerOutputPort,
      SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
    this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
  }

  @Override
  public void insert(Customer customer, String zipCode) {
    var address = findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    insertCustomerOutputPort.insert(customer);
    sendCpfForValidationOutputPort.send(customer.getCpf());
  }
}