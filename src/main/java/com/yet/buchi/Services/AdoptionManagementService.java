package com.yet.buchi.Services;


import com.yet.buchi.DTOs.RequestDTOs.AdoptionListDto;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionListIn;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionRegistrationIn;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionReportListDto;
import com.yet.buchi.DTOs.ResponseDTOs.ListAdoptionOut;
import com.yet.buchi.DTOs.ResponseDTOs.ListCustomerOut;
import com.yet.buchi.Utilities.StatusInit;
import com.yet.buchi.convertors.AdoptionConvertor;
import com.yet.buchi.models.Adoption;
import com.yet.buchi.models.Customer;
import com.yet.buchi.models.Pet;
import com.yet.buchi.repository.AdoptionRepository;
import com.yet.buchi.repository.CustomerRepository;
import com.yet.buchi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdoptionManagementService {

    @Autowired
    StatusInit statusInit;
    @Autowired
    AdoptionConvertor adoptionConvertor;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PetRepository petRepository;
    @Autowired
    AdoptionRepository adoptionRepository;

    public ListAdoptionOut addAdoption(AdoptionRegistrationIn adoptionRegistrationIn) {


        ListAdoptionOut listAdoptionOut = new ListAdoptionOut();

        Adoption adoption = new Adoption();
        Customer customerById = customerRepository.findCustomerById(adoptionRegistrationIn.getCustomerId());
        Pet petById = petRepository.findPetById(adoptionRegistrationIn.getPetId());
        adoption.setCustomer(customerById);
        adoption.setPet(petById);
        adoption.setRequestDate(new Date());
        adoptionRepository.save(adoption);

        listAdoptionOut.setStatus(statusInit.successful());
        listAdoptionOut.setAdoptionId(adoption.getId());

        return listAdoptionOut;
}

    public AdoptionListDto listAdoption(AdoptionListIn adoptionListIn) {

        AdoptionListDto adoptionListDto = new AdoptionListDto();
        List<Adoption> allBetweenDates = adoptionRepository.getAllBetweenDates(adoptionListIn.getStartDate(), adoptionListIn.getEndDate());


        if (!allBetweenDates.isEmpty()) {
            adoptionListDto.setAdoptionDtos(adoptionConvertor.toAdoptionDtoList(allBetweenDates));
            adoptionListDto.setCount(adoptionRepository.count());
            adoptionListDto.setStatus(statusInit.successful());
        }
        else {
            adoptionListDto.setAdoptionDtos(new ArrayList<>());
            adoptionListDto.setCount(0);
            adoptionListDto.setStatus(statusInit.singleErrorInit("No Record", "No Adoption Request Found"));
        }
        return adoptionListDto;

    }

    public AdoptionReportListDto adoptionReportList(AdoptionListIn adoptionListIn) throws ParseException {

        AdoptionReportListDto adoptionReportListDto = new AdoptionReportListDto();
        List<Adoption> allBetweenDates = adoptionRepository.getAllBetweenDates(adoptionListIn.getStartDate(), adoptionListIn.getEndDate());
        if (!allBetweenDates.isEmpty()) {
            adoptionReportListDto.setAdoptedPetTypeDtos(adoptionConvertor.toAdoptedPetTypeDtoList(allBetweenDates));
            adoptionReportListDto.setWeeklyAdoptionRequestDtos(adoptionConvertor.toWeeklyAdoptionRequestDtoList(allBetweenDates));
            adoptionReportListDto.setStatus(statusInit.successful());
        }
        else {
            adoptionReportListDto.setWeeklyAdoptionRequestDtos(new ArrayList<>());
            adoptionReportListDto.setAdoptedPetTypeDtos(new ArrayList<>());
            adoptionReportListDto.setStatus(statusInit.singleErrorInit("No Record", "No Adoption Request Found"));
        }
        return adoptionReportListDto;

    }

}
