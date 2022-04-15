package com.yet.buchi.controllers;

import com.yet.buchi.DTOs.RequestDTOs.AdoptionListDto;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionListIn;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionRegistrationIn;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionReportListDto;
import com.yet.buchi.DTOs.ResponseDTOs.ListAdoptionOut;
import com.yet.buchi.DTOs.ResponseDTOs.ListCustomerOut;
import com.yet.buchi.Services.AdoptionManagementService;
import com.yet.buchi.Services.CustomerManagementService;
import com.yet.buchi.models.Customer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController

@Api(value = "adoption management")
public class AdoptionController {

    @Autowired
    AdoptionManagementService adoptionManagementService;


    @PostMapping("/api/buchi/addAdoption")
    public ListAdoptionOut addAdoption(@Valid @RequestBody AdoptionRegistrationIn adoptionRegistrationIn) {
        return adoptionManagementService.addAdoption(adoptionRegistrationIn);
    }
    @GetMapping("/api/buchi/listAdoption")
    public AdoptionListDto adoptionList(AdoptionListIn adoptionListIn) {
        return adoptionManagementService.listAdoption(adoptionListIn);
    }
    @GetMapping("/api/buchi/adoptionReport")

    public AdoptionReportListDto adoptionReportList(AdoptionListIn adoptionListIn) throws ParseException {
        return adoptionManagementService.adoptionReportList(adoptionListIn);
    }



}
