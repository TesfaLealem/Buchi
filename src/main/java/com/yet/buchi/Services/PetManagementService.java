package com.yet.buchi.Services;

import com.yet.buchi.DTOs.RequestDTOs.PetListDto;
import com.yet.buchi.DTOs.RequestDTOs.PetListIn;
import com.yet.buchi.DTOs.ResponseDTOs.ListPetOut;
import com.yet.buchi.Utilities.FileUploadUtil;
import com.yet.buchi.Utilities.StatusInit;
import com.yet.buchi.convertors.PetConvertor;
import com.yet.buchi.models.Pet;
import com.yet.buchi.repository.PetRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetManagementService {
    @Autowired
    PetRepository petRepository;
    @Autowired
    PetConvertor petConvertor;
    @Autowired
    StatusInit statusInit;

    public ListPetOut addPet(Pet pet,
                             MultipartFile multipartFile) throws IOException {

        ListPetOut listPetOut = new ListPetOut();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Pet pet1 = new Pet();
        pet1.setType(pet.getType());
        pet1.setAge(pet.getAge());
        pet1.setGender(pet.getGender());
        pet1.setGoodWithChildren(pet.isGoodWithChildren());
        pet1.setPicturePath(fileName);
        pet1.setSize(pet.getSize());

        petRepository.save(pet1);

        String uploadDir = "pet-photos/" + pet1.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        listPetOut.setStatus(statusInit.successful());
        listPetOut.setPetId(pet1.getId());


        return listPetOut;
    }

    public PetListDto listPet(PetListIn petListIn) {

        PetListDto petListDto = new PetListDto();


        PageRequest pageRequest = PageRequest.of(0,petListIn.getLimit());
        List<Pet> petRepositoryAll = petRepository.searchPets(petListIn.getType(),pageRequest);


        if (!petRepositoryAll.isEmpty()) {
            petListDto.setPetDtos(petConvertor.toPetDtoList(petRepositoryAll));
            petListDto.setCount(petRepositoryAll.size());
            petListDto.setStatus(statusInit.successful());
        }
        else {
            petListDto.setPetDtos(new ArrayList<>());
            petListDto.setCount(0);
            petListDto.setStatus(statusInit.singleErrorInit("No Record", "No Pet Found"));
        }
        return petListDto;

    }

}
