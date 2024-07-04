package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Address;
import org.jaax.fase1.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        Customer customer = Customer.builder()
                .firstname("Moises2")
                .lastname("Silva")
                .email("moises2.silva@gmail.com")
                .build();
        customerRepository.save(customer);
    }

    @Test
    public void saveCustomerWithAddressEmbedded(){
        Address address = Address.builder()
                .mainStreet("Av Camacho")
                .secondaryStreet("calle Juan de la Riva")
                .city("La Paz")
                .build();

        Customer customer = Customer.builder()
                .firstname("Marcos")
                .lastname("Andrade")
                .email("marcos.andrade@gmail.com")
                .address(address)
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

    @Test
    public void findAllCustomerFirstNameContaining(){
        List<Customer> customerList = customerRepository.findByFirstnameContainingIgnoreCase("os");
        System.out.println("customer = " + customerList);
    }

    @Test
    public void findAllCustomersLastNameNotNull(){
        List<Customer> customerList = customerRepository.findByLastnameNotNull();
        System.out.println("customer = " + customerList);
    }

    @Test
    public void findAllCustomersByAddressCity(){
        List<Customer> customerList = customerRepository.findByAddress_CityContainingIgnoreCase("paz");
        System.out.println("customer = " + customerList);
    }
}