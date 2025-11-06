package io.github.lcmdev.hexagonal.adapters.in.controller;

import io.github.lcmdev.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import io.github.lcmdev.hexagonal.adapters.in.controller.request.CustomerRequest;
import io.github.lcmdev.hexagonal.adapters.in.controller.response.CustomerResponse;
import io.github.lcmdev.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import io.github.lcmdev.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import io.github.lcmdev.hexagonal.application.ports.in.InsertCustomerInputPort;
import io.github.lcmdev.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final InsertCustomerInputPort insertCustomerInputPort;
  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final UpdateCustomerInputPort updateCustomerInputPort;
  private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
  private final CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
    var customer = customerMapper.toCustomer(customerRequest);
    insertCustomerInputPort.insert(customer, customerRequest.getZipCode());

    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
    var customer = findCustomerByIdInputPort.find(id);
    var customerResponse = customerMapper.toCustomerResponse(customer);
    return ResponseEntity.ok().body(customerResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
    var customer = customerMapper.toCustomer(customerRequest);
    customer.setId(id);
    updateCustomerInputPort.update(customer, customerRequest.getZipCode());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable final String id){
    deleteCustomerByIdInputPort.delete(id);
    return ResponseEntity.noContent().build();
  }
}