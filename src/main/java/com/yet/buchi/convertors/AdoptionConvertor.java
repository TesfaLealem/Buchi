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

        PetListIn petListIn = new PetListIn();


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

    public AdoptedPetTypeDto toAdoptedPetTypeDto(Adoption adoption) {


        Adoption adoptionById = adoptionRepository.findAdoptionById(adoption.getId());
        Pet petById = petRepository.findPetById(adoptionById.getPet().getId());

        AdoptedPetTypeDto adoptedPetTypeDto = new AdoptedPetTypeDto();

        List<Pet> dogPets = new ArrayList<>();
        List<Pet> catPets = new ArrayList<>();
        String cat = "";
        String dog = "";
        int dogAmount =0;
        int catAmount =0;

        if(petById.getType().equals("Dog")){
            dogPets.add(petById);
            dog = "Dog";
        }
        if (petById.getType().equals("Cat")){
            catPets.add(petById);
            cat = "Cat";
        }

        dogAmount=dogPets.size();
        catAmount=catPets.size();

        adoptedPetTypeDto.setDog(dog + "" + "=" + "" + dogAmount);
        adoptedPetTypeDto.setCat(cat + "" + "=" + "" + catAmount);


        return adoptedPetTypeDto;
    }

    public WeeklyAdoptionRequestDto toWeeklyAdoptionRequestDto (Adoption adoption) throws ParseException {


        Adoption adoptionById = adoptionRepository.findAdoptionById(adoption.getId());

        WeeklyAdoptionRequestDto weeklyAdoptionRequestDto = new WeeklyAdoptionRequestDto();


        List<Adoption> firstWeekAdoptions = new ArrayList<>();
        List<Adoption> secondWeekAdoptions = new ArrayList<>();
        List<Adoption> thirdWeekAdoptions = new ArrayList<>();
        List<Adoption> fourthWeekAdoptions = new ArrayList<>();
        int weekOneAmount =0;
        int weekTwoAmount =0;
        int weekThreeAmount =0;
        int weekFourAmount =0;

        Date week1,week2,week3,week4,last;

        String firstWeek="01/02/2022";
        String secondWeek="08/02/2022";
        String thirdWeek="16/02/2022";
        String fourthWeek="23/02/2022";
        String lastDay="30/02/2022";


        week1=new SimpleDateFormat("dd/MM/yyyy").parse(firstWeek);
        week2=new SimpleDateFormat("dd/MM/yyyy").parse(secondWeek);
        week3=new SimpleDateFormat("dd/MM/yyyy").parse(thirdWeek);
        week4=new SimpleDateFormat("dd/MM/yyyy").parse(fourthWeek);
        last=new SimpleDateFormat("dd/MM/yyyy").parse(lastDay);

        if (adoptionById.getRequestDate().before(week2) && adoptionById.getRequestDate().after(week1)){
            firstWeekAdoptions.add(adoptionById);
        }
        else if(adoptionById.getRequestDate().before(week3)  && adoptionById.getRequestDate().after(week2)){
            secondWeekAdoptions.add(adoptionById);
        }
        else if(adoptionById.getRequestDate().before(week4) && adoptionById.getRequestDate().after(week3)){
            thirdWeekAdoptions.add(adoptionById);
        }
        else if(adoptionById.getRequestDate().before(last) && adoptionById.getRequestDate().after(week4)){
            fourthWeekAdoptions.add(adoptionById);
        }

        weekOneAmount = firstWeekAdoptions.size();
        weekTwoAmount = secondWeekAdoptions.size();
        weekThreeAmount = thirdWeekAdoptions.size();
        weekFourAmount = fourthWeekAdoptions.size();

        weeklyAdoptionRequestDto.setWeek1(firstWeek + "" + "=" + weekOneAmount);
        weeklyAdoptionRequestDto.setWeek2(secondWeek + "" + "=" + weekTwoAmount);
        weeklyAdoptionRequestDto.setWeek3(thirdWeek + "" + "=" + weekThreeAmount);
        weeklyAdoptionRequestDto.setWeek4(fourthWeek + "" + "=" + weekFourAmount);

        return weeklyAdoptionRequestDto;
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

    public List<AdoptedPetTypeDto> toAdoptedPetTypeDtoList(List<Adoption> adoptionLists) {
        List<AdoptedPetTypeDto> adoptedPetTypeDtoList = new ArrayList<AdoptedPetTypeDto>();
        for (Adoption adoptionList : adoptionLists) {
            AdoptedPetTypeDto adoptedPetTypeDto = new AdoptedPetTypeDto();
            adoptedPetTypeDto = this.toAdoptedPetTypeDto(adoptionList);
            adoptedPetTypeDtoList.add(adoptedPetTypeDto);
        }
        return adoptedPetTypeDtoList;
    }

    public List<WeeklyAdoptionRequestDto> toWeeklyAdoptionRequestDtoList(List<Adoption> adoptionLists) throws ParseException {
        List<WeeklyAdoptionRequestDto> weeklyAdoptionRequestDtoList = new ArrayList<WeeklyAdoptionRequestDto>();
        for (Adoption adoptionList : adoptionLists) {
            WeeklyAdoptionRequestDto weeklyAdoptionRequestDto = new WeeklyAdoptionRequestDto();
            weeklyAdoptionRequestDto = this.toWeeklyAdoptionRequestDto(adoptionList);
            weeklyAdoptionRequestDtoList.add(weeklyAdoptionRequestDto);
        }
        return weeklyAdoptionRequestDtoList;
    }

}
