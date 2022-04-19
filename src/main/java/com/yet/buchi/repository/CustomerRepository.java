package com.yet.buchi.repository;



import com.yet.buchi.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    void deleteCustomerById(Long id);

    Boolean existsByPhone(String phone);

    @Query("select c from Customer c  where c.id in :customerId")
    public Customer findCustomerById(@Param("customerId") Long customerId);

    @Query("select c from Customer c  where c.phone in :phoneNumber")
    public Customer findCustomerByPhone(@Param("phoneNumber") String phoneNumber);


}

