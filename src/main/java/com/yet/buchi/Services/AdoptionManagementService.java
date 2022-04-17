package com.yet.buchi.Services;


import com.yet.buchi.DTOs.RequestDTOs.AdoptionListDto;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionListIn;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionRegistrationIn;
import com.yet.buchi.DTOs.RequestDTOs.AdoptionReportListDto;
import com.yet.buchi.DTOs.ResponseDTOs.ListAdoptionOut;
import com.yet.buchi.DTOs.ResponseDTOs.ListCustomerOut;
import com.yet.buchi.DTOs.RestData.AdoptedPetTypeDto;
import com.yet.buchi.DTOs.RestData.WeeklyAdoptionRequestDto;
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
import java.text.SimpleDateFormat;
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
            adoptionListDto.setCount(allBetweenDates.size());
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
        AdoptedPetTypeDto adoptedPetTypeDto = new AdoptedPetTypeDto();
        WeeklyAdoptionRequestDto weeklyAdoptionRequestDto = new WeeklyAdoptionRequestDto();
        Date week1,week2,week3,week4,last;

        String firstWeek="2022-04-01";
        String secondWeek="2022-04-08";
        String thirdWeek="2022-04-16";
        String fourthWeek="2022-04-23";
        String lastDay="2022-04-30";

        week1=new SimpleDateFormat("yyyy-MM-dd").parse(firstWeek);
        week2=new SimpleDateFormat("yyyy-MM-dd").parse(secondWeek);
        week3=new SimpleDateFormat("yyyy-MM-dd").parse(thirdWeek);
        week4=new SimpleDateFormat("yyyy-MM-dd").parse(fourthWeek);
        last=new SimpleDateFormat("yyyy-MM-dd").parse(lastDay);
        if (!allBetweenDates.isEmpty()) {
            int dogAmount =0;
            int catAmount =0;
            int weekOneAmount =0;
            int weekTwoAmount =0;
            int weekThreeAmount =0;
            int weekFourAmount =0;
            for (Adoption adoptionList : allBetweenDates) {

                Pet petById = petRepository.findPetById(adoptionList.getPet().getId());

                if(petById.getType().equals("Dog")){
                    dogAmount++;
                }
                if (petById.getType().equals("Cat")){
                    catAmount++;
                }

                if (adoptionList.getRequestDate().before(week2) && adoptionList.getRequestDate().after(week1)){
                    weekOneAmount++;
                }
                else if(adoptionList.getRequestDate().before(week3)  && adoptionList.getRequestDate().after(week2)){
                    weekTwoAmount++;
                }
                else if(adoptionList.getRequestDate().before(week4) && adoptionList.getRequestDate().after(week3)){
                    weekThreeAmount++;
                }
                else if(adoptionList.getRequestDate().before(last) && adoptionList.getRequestDate().after(week4)){
                    weekFourAmount++;
                }
            }
            adoptedPetTypeDto.setDog("Dog = " + dogAmount);
            adoptedPetTypeDto.setCat("Cat = " + catAmount);

            weeklyAdoptionRequestDto.setWeek1(firstWeek + "=" + "" + "=" + weekOneAmount);
            weeklyAdoptionRequestDto.setWeek2(secondWeek + "=" + "" + "=" + weekTwoAmount);
            weeklyAdoptionRequestDto.setWeek3(thirdWeek + "=" + "" + "=" + weekThreeAmount);
            weeklyAdoptionRequestDto.setWeek4(fourthWeek + "=" + "" + "=" + weekFourAmount);

            adoptionReportListDto.setAdoptedPetTypeDto(adoptedPetTypeDto);
            adoptionReportListDto.setWeeklyAdoptionRequestDto(weeklyAdoptionRequestDto);
            adoptionReportListDto.setStatus(statusInit.successful());

        }
        else {
            adoptionReportListDto.setAdoptedPetTypeDto(null);
            adoptionReportListDto.setWeeklyAdoptionRequestDto(null);
            adoptionReportListDto.setStatus(statusInit.singleErrorInit("No Record", "No Adoption Request Found"));
        }
        return adoptionReportListDto;

    }

}
