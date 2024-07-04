package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        Customer customer = Customer.builder().firstname("Moises2").lastname("Silva")
//                .email("moises2.silva@gmail.com")
                .build();
        customerRepository.save(customer);
    }

    @Test
    public void findCustomerByFirstname(){
        Customer customer = customerRepository.findByFirstname("Moises").get();
        System.out.println("customer = " + customer);
    }

    @Test
    public void findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        System.out.println("customer = " + customers);
    }
}