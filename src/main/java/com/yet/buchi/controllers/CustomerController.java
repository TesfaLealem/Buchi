package com.yet.buchi.controllers;
import com.yet.buchi.DTOs.ResponseDTOs.ListCustomerOut;
import com.yet.buchi.Services.CustomerManagementService;
import com.yet.buchi.models.Customer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@Api(value = "customer management")
public class CustomerController {

    @Autowired
    CustomerManagementService customerManagementService;

    @PostMapping("/api/buchi/addCustomer")
    public  ListCustomerOut addCustomer(@Valid @RequestBody Customer customer) {
        return customerManagementService.addCustomer(customer);
    }
    @GetMapping("/api/buchi/listCustomer")
    public List<Customer> customerList() {
        return customerManagementService.listCustomer();
    }



}
