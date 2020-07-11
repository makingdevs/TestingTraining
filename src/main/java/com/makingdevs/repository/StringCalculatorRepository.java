package com.makingdevs.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.makingdevs.model.StringCalculatorData;

@RepositoryRestResource(path = "string_calculator")
public interface StringCalculatorRepository extends PagingAndSortingRepository<StringCalculatorData, Long> {
}
