package io.github.lcmdev.hexagonal.application.ports.out;

import io.github.lcmdev.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

  Address find(String zipCode);
}