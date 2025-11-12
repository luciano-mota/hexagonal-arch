package io.github.lcmdev.hexagonal.adapters.in.consumer;

import io.github.lcmdev.hexagonal.adapters.in.consumer.message.CustomerMessage;
import io.github.lcmdev.hexagonal.application.ports.in.UpdateCustomerInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {

  private final UpdateCustomerInputPort updateCustomerInputPort;
  private final CustomerMessageMapper customerMessageMapper;

  @KafkaListener(topics = "tp-cpf-validated", groupId = "lcmdev")
  public void receive(CustomerMessage customerMessage) {
    var customer = customerMessageMapper.toCustomer(customerMessage);
    updateCustomerInputPort.update(customer, customerMessage.getZipCode());
  }
}
