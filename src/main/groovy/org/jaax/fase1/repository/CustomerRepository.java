package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

        Optional<Customer> findByFirstname(String firstname);

        List<Customer> findByFirstnameContainingIgnoreCase(String firstname);

        List<Customer> findByLastnameNotNull();

        List<Customer> findByAddress_CityContainingIgnoreCase(String city);
}
