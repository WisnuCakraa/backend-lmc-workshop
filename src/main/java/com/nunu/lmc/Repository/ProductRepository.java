package com.nunu.lmc.Repository;

import com.nunu.lmc.Entity.Product;
import com.nunu.lmc.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    @Query("SELECT p from Product p where p.name = ?1")
    Optional<User> findByProductName(String name);
}
