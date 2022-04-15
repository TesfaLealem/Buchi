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

        if(customerRepository.existsByPhone(customer.getPhone())){
            Customer customerByPhone = customerRepository.findCustomerByPhone(customer.getPhone());
            Customer customerById = customerRepository.findCustomerById(customerByPhone.getId());
            listCustomerOut.setStatus(statusInit.successful());
            listCustomerOut.setCustomerId(customerById.getId());
        }
        else {
            Customer customer1 = new Customer();
            customer1.setName(customer.getName());
            customer1.setPhone(customer.getPhone());
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
