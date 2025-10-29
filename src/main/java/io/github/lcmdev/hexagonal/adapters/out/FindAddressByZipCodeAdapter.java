package io.github.lcmdev.hexagonal.adapters.out;

import io.github.lcmdev.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import io.github.lcmdev.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import io.github.lcmdev.hexagonal.application.core.domain.Address;
import io.github.lcmdev.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

  private final FindAddressByZipCodeClient findAddressBuZipCodeClient;
  private final AddressResponseMapper addressResponseMapper;

  @Override
  public Address find(String zipCode) {
    var addressResponse = findAddressBuZipCodeClient.find(zipCode);
    return addressResponseMapper.toAddress(addressResponse);
  }
}