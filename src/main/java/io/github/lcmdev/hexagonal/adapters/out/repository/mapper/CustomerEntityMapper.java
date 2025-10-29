package io.github.lcmdev.hexagonal.adapters.out.repository.mapper;

import io.github.lcmdev.hexagonal.adapters.out.repository.entity.CustomerEntity;
import io.github.lcmdev.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

  CustomerEntity toCustomerEntity(Customer customer);
}