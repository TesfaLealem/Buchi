package com.yet.buchi.Services;


import com.yet.buchi.DTOs.ResponseDTOs.ListCustomerOut;
import com.yet.buchi.Utilities.StatusInit;
import com.yet.buchi.models.Customer;
import com.yet.buchi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManagementService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    StatusInit statusInit;

    public ListCustomerOut addCustomer(Customer customer) {

        ListCustomerOut listCustomerOut = new ListCustomerOut();

        Customer customerByPhone1 = customerRepository.findCustomerByPhone(customer.getPhone());

        if(customerByPhone1 !=null){
            listCustomerOut.setStatus(statusInit.successful());
            listCustomerOut.setCustomerId(customerByPhone1.getId());
        }
        else {

            Customer customer1 = new Customer();
            customer1.setPhone(customer.getPhone());
            customer1.setName(customer.getName());
            customerRepository.save(customer1);
            listCustomerOut.setStatus(statusInit.successful());
            listCustomerOut.setCustomerId(customer1.getId());
        }
        return listCustomerOut;
}

    public List<Customer> listCustomer() {
        return customerRepository.findAll();
    }



}
