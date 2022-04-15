package com.yet.buchi.controllers;

import com.yet.buchi.DTOs.RequestDTOs.PetListDto;
import com.yet.buchi.DTOs.ResponseDTOs.ListCustomerOut;
import com.yet.buchi.Services.CustomerManagementService;
import com.yet.buchi.Services.PetManagementService;
import com.yet.buchi.models.Customer;
import com.yet.buchi.models.Pet;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import java.io.IOException;
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
