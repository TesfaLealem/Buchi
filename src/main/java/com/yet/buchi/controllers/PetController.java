package com.yet.buchi.controllers;

import com.yet.buchi.DTOs.RequestDTOs.PetListDto;
import com.yet.buchi.DTOs.RequestDTOs.PetListIn;
import com.yet.buchi.DTOs.ResponseDTOs.ListPetOut;
import com.yet.buchi.Services.PetManagementService;
import com.yet.buchi.models.Pet;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Api(value = "pet management")
public class PetController {
    @Autowired
    PetManagementService petManagementService;

    @PostMapping("/api/buchi/addPet")
    public ListPetOut addPet(Pet pet, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        return petManagementService.addPet(pet,multipartFile);
    }
    @GetMapping("/api/buchi/listPet")
    public PetListDto petList(PetListIn petListIn) {
        return petManagementService.listPet(petListIn);
    }

}
