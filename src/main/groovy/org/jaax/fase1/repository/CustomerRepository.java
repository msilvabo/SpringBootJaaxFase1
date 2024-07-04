package org.jaax.fase1.repository;

import org.jaax.fase1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

        Optional<Customer> findByFirstname(String firstname);

        List<Customer> findByFirstnameContainingIgnoreCase(String firstname);

        List<Customer> findByLastnameNotNull();

        List<Customer> findByAddress_CityContainingIgnoreCase(String city);

        @Query("select c from Customer c where c.email=?1")
        Customer getCustomerByEmailAddress(String emailAddress);

        @Query("select concat(concat(c.firstname, ' '),c.lastname)  from Customer c where c.email=?1")
        String getCustomerNameByEmailAddress(String emailAddress);

        @Query(
                value = "select 'Address : ' || customer_main_street || ' -- City : ' || customer_city from tbl_customer where email_address = ?1",
                nativeQuery = true
        )
        String getCustomerbyEmailAddressNative(String emailAddress);

        @Query(
                value = "select 'Address : ' || customer_main_street || ' -- City : ' || customer_city from tbl_customer where email_address = :emailAddress and firstName= :firstName",
                nativeQuery = true
        )
        String getCustomerbyEmailAddressNativeNamedParam(@Param("emailAddress") String emailAddress, @Param("firstName") String firstname);
}
