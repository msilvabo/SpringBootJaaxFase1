package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

        Optional<Customer> findByFirstname(String firstname);
}
