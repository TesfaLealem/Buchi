package com.yet.buchi.convertors;


import com.yet.buchi.DTOs.RequestDTOs.PetListIn;
import com.yet.buchi.DTOs.RestData.AdoptedPetTypeDto;
import com.yet.buchi.DTOs.RestData.AdoptionDto;
import com.yet.buchi.DTOs.RestData.PetDto;
import com.yet.buchi.DTOs.RestData.WeeklyAdoptionRequestDto;
import com.yet.buchi.models.Adoption;
import com.yet.buchi.models.Customer;
import com.yet.buchi.models.Pet;
import com.yet.buchi.repository.AdoptionRepository;
import com.yet.buchi.repository.CustomerRepository;
import com.yet.buchi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdoptionConvertor {
    @Autowired
    PetRepository petRepository;
    @Autowired
    AdoptionRepository adoptionRepository;
    @Autowired
    CustomerRepository customerRepository;

    public AdoptionDto toAdoptionDto(Adoption adoption) {

        Adoption adoptionById = adoptionRepository.findAdoptionById(adoption.getId());
        Pet petById = petRepository.findPetById(adoptionById.getPet().getId());
        Customer customerById = customerRepository.findCustomerById(adoptionById.getCustomer().getId());

        AdoptionDto adoptionDto = new AdoptionDto();

        adoptionDto.setCustomerId(customerById.getId());
        adoptionDto.setPhone(customerById.getPhone());
        adoptionDto.setCustomerName(customerById.getName());
        adoptionDto.setPetId(petById.getId());
        adoptionDto.setAge(petById.getAge());
        adoptionDto.setGender(petById.getGender());
        adoptionDto.setGoodWithChildren(petById.isGoodWithChildren());
        adoptionDto.setSize(petById.getSize());
        adoptionDto.setType(petById.getType());

        return adoptionDto;
    }




    public List<AdoptionDto> toAdoptionDtoList(List<Adoption> adoptionLists) {
        List<AdoptionDto> adoptionDtoList = new ArrayList<AdoptionDto>();
        for (Adoption adoptionList : adoptionLists) {
            AdoptionDto adoptionDto = new AdoptionDto();
            adoptionDto = this.toAdoptionDto(adoptionList);
            adoptionDtoList.add(adoptionDto);
        }

        return adoptionDtoList;
    }

}
