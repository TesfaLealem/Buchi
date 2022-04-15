package com.yet.buchi.convertors;


import com.yet.buchi.DTOs.RestData.PetDto;
import com.yet.buchi.models.Pet;
import com.yet.buchi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetConvertor {
    @Autowired
    PetRepository petRepository;

    public PetDto toPetDto(Pet pet) {

        Pet petById = petRepository.findPetById(pet.getId());
        PetDto petDto = new PetDto();
        petDto.setId(petById.getId());
        petDto.setType(petById.getType());
        petDto.setAge(petById.getAge());
        petDto.setGender(petById.getGender());
        petDto.setGoodWithChildren(petById.isGoodWithChildren());
        petDto.setPicturePath("/pet-photos/" + petById.getId() + "/" + petById.getPicturePath());
        petDto.setSize(petById.getSize());

        return petDto;
    }

    public List<PetDto> toPetDtoList(List<Pet> petLists) {
        List<PetDto> petDtoList = new ArrayList<PetDto>();
        for (Pet petList : petLists) {
            PetDto petDto = new PetDto();
            petDto = this.toPetDto(petList);
            petDtoList.add(petDto);
        }

        return petDtoList;
    }

}
