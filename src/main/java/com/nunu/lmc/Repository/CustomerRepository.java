package com.nunu.lmc.Repository;

import com.nunu.lmc.Entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    @Query("SELECT c from Customer c where c.email = ?1")
    Optional<Customer> findByEmail(String email);
}
