package com.makingdevs.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.repository.PagingAndSortingRepository

@RepositoryRestResource
public class StringCalulatorRepository extends PagingAndSortingRepository<StringCalculatorData, Long> {
}
