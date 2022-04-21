package com.yet.buchi.controllers;
import com.yet.buchi.DTOs.RequestDTOs.PetListDto;
import com.yet.buchi.DTOs.RequestDTOs.PetListIn;
import com.yet.buchi.DTOs.ResponseDTOs.ListPetOut;
import com.yet.buchi.Services.PetManagementService;
import com.yet.buchi.models.Pet;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;



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

//    @GetMapping("/api/buchi/animals")
//    public ResponseEntity  getAnimals() throws JSONException {
//        String url = "https://api.petfinder.com/v2/animals";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setBearerAuth("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJnVDdReVh3aklTZDJxaVZCUkRSTE5FNTQ0akltVEFWT25zb2Fpb0w5cU1NaGpWdWY3dSIsImp0aSI6IjNkZjNjOWQxOTUzZDFhODBkNTZiNDJkMmM5OWI0MGZiZDIxYzRhMGRiODdmNGM1NjQ5YTRkYTY3MTYyMWI3MmY5ZDIwNTNmODg1ZDk5YjgzIiwiaWF0IjoxNjUwMzQ4MDgyLCJuYmYiOjE2NTAzNDgwODIsImV4cCI6MTY1MDM1MTY4Miwic3ViIjoiIiwic2NvcGVzIjpbXX0.kLKLHGHLwRsBpAWlLinpF-xsZWuUYUX8lmxfhte-dSJQbU0S825CXwHZAkTIQCan1OyhahtwoQiP7n3z1BBEUrdLTIA9wPlhB8ym5tE0OCPvnsFF9ur3JfSjelNyfZsns-4TfASUjDb2gA2zJMvkRp4L5S7WupImu53_l0EX3Bpl0Y4P-fm-wKWqancuuAeBzKY8ivr9vzqfpr59nI26cjMJZB7acZ-HxSHaYNwrePFhr4edpLeJIfXRi6stQH8xRn-pb93NKn9RQgRCcK21kGsJDgFz0aozXoEv6TuYkhh5LaqY0vFShrmGupICqp-CEWYA855uNz35jTTp9jArXg");
//        HttpEntity<String> entity =  new HttpEntity<>("parameters", headers);
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        return exchange;
//    }

}
