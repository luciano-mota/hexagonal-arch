package io.github.lcmdev.hexagonal.adapters.out.client.mapper;

import io.github.lcmdev.hexagonal.adapters.out.client.response.AddressResponse;
import io.github.lcmdev.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
