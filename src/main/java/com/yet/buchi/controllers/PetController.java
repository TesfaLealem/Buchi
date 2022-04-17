package com.yet.buchi.controllers;

import com.yet.buchi.DTOs.RequestDTOs.PetListDto;
import com.yet.buchi.DTOs.RequestDTOs.PetListIn;
import com.yet.buchi.DTOs.ResponseDTOs.ListPetOut;
import com.yet.buchi.Services.PetManagementService;
import com.yet.buchi.models.Pet;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static javafx.scene.input.KeyCode.H;

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

    @GetMapping("/api/buchi/animals")
    public ResponseEntity  getAnimals() throws JSONException {
        String url = "https://api.petfinder.com/v2/animals";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth("eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJnVDdReVh3aklTZDJxaVZCUkRSTE5FNTQ0akltVEFWT25zb2Fpb0w5cU1NaGpWdWY3dSIsImp0aSI6IjYxMGZhZWMwYmRkNzczNDJlODU3MjU3MGQ0NzIzMTJhMDI4ZjY1MzBiNzliNjlhNmUxYzQxNTJlZGVlOWNmMjE5OTllMzg5OTM5ZDYyYmM4IiwiaWF0IjoxNjUwMTk0OTAxLCJuYmYiOjE2NTAxOTQ5MDEsImV4cCI6MTY1MDE5ODUwMSwic3ViIjoiIiwic2NvcGVzIjpbXX0.Z_feEpuGybT06wUy9WVB9b6aHkOuSZs6fMJ9wh69muJebXOMgIauwpFk_nSUudX_oHUXMN2jmz8Oz4IbRochJXL8rYsQGYF9TBoDMK4isowow2B8-vV2P044ch24UEmMgSOoAQR9N71MjapH8Mo1gRBe12r857s1J2Qn_Kzq3iTvcZFn3j7f54k4u3GKXnTahQZR9hRt2HNZ7zXsWDaWa3w4pVx-Gc90ABD6AawTsOfDIVdI1WGXP-C66ICmqlDFH2gjLthrCG4i-1Taw5ZEnApRhv4sgPHnPYdcaAdFkWMh6_BfnmaTdxgD2eR5lX2YKYaoiSC5waW1oe2n6f4okA");

        HttpEntity<String> entity =  new HttpEntity<>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class, new ParameterizedTypeReference<List<String>>(){});
        ResponseEntity<JSONObject> exchange1 = restTemplate.exchange(url, HttpMethod.GET, entity, JSONObject.class, new ParameterizedTypeReference<List<String>>() {
        });

        String listOfString = exchange.getBody();

        /* String api = "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJnVDdReVh3aklTZDJxaVZCUkRSTE5FNTQ0akltVEFWT25zb2Fpb0w5cU1NaGpWdWY3dSIsImp0aSI6IjA4YmFlYzA0MjA3NjM1MzUwNjRiNzZmMDdiOTg2MjRkYzdjYmRkZTE4ZGMzY2YzOTM2OGNkNjNmM2Q1ZDM0MDYzOGJmMmRiMzM5ZmY4OGY4IiwiaWF0IjoxNjUwMTMyMzAyLCJuYmYiOjE2NTAxMzIzMDIsImV4cCI6MTY1MDEzNTkwMiwic3ViIjoiIiwic2NvcGVzIjpbXX0.WVxQcrj54Z_7eqlq_kulnK-lpsMAyaHDZQu8CeTTo5D7Q6efsCI4vpxhGQNPL1zSY7eowNXLUKt0aBnqlO-04ZzjtxFsIASRYIQSqgUrWUjl-HdGFoiQegirW1YzJUqJqUe5Zx0fidfN34xGHaSQUre2qnHHK_6vzwQrmBF0IZU9NR5-e5JU0_P4quq4wtpYzk_MxboMxkx-kQtE-CYfy86g5PjfM2dPSlH9lTgwGL0ppB97Zy_dhLeZk4f_o59Mpkc-RMujHj8bheV8PZkAQbnzlg4zvlMwf_JLPxJK7m_aVVPJgN1FIMyxM3qV5FexKGWACnDV0Ml6zVxc7lbSCg";
        String vha ="Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJnVDdReVh3aklTZDJxaVZCUkRSTE5FNTQ0akltVEFWT25zb2Fpb0w5cU1NaGpWdWY3dSIsImp0aSI6IjA4YmFlYzA0MjA3NjM1MzUwNjRiNzZmMDdiOTg2MjRkYzdjYmRkZTE4ZGMzY2YzOTM2OGNkNjNmM2Q1ZDM0MDYzOGJmMmRiMzM5ZmY4OGY4IiwiaWF0IjoxNjUwMTMyMzAyLCJuYmYiOjE2NTAxMzIzMDIsImV4cCI6MTY1MDEzNTkwMiwic3ViIjoiIiwic2NvcGVzIjpbXX0.WVxQcrj54Z_7eqlq_kulnK-lpsMAyaHDZQu8CeTTo5D7Q6efsCI4vpxhGQNPL1zSY7eowNXLUKt0aBnqlO-04ZzjtxFsIASRYIQSqgUrWUjl-HdGFoiQegirW1YzJUqJqUe5Zx0fidfN34xGHaSQUre2qnHHK_6vzwQrmBF0IZU9NR5-e5JU0_P4quq4wtpYzk_MxboMxkx-kQtE-CYfy86g5PjfM2dPSlH9lTgwGL0ppB97Zy_dhLeZk4f_o59Mpkc-RMujHj8bheV8PZkAQbnzlg4zvlMwf_JLPxJK7m_aVVPJgN1FIMyxM3qV5FexKGWACnDV0Ml6zVxc7lbSCg  https://api.petfinder.com/v2/animals";


        Object[] animals = restTemplate.getForObject(vha  , Object[].class);
*/
      /*  ResponseEntity<Employee[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8080/employees/",
                        Employee[].class);
        Employee[] employees = response.getBody();

*/      String pet="";


       /* if(exchange != null && exchange.hasBody()){
            List<String> myList = Collections.singletonList(exchange.getBody());

        }*/
        /*ResponseEntity<Object[]> responseEntity =
                restTemplate.getForEntity(BASE_URL, Object[].class);

        Next, we can extract the body into our array of Object:

        Object[] objects = responseEntity.getBody();*/
        //String body = exchange.getBody();
        // System.out.println("size " + myList.size());

        String[] animals = listOfString.split("Dog");
        System.out.println("animals length" + animals.length);
        System.out.println("list of animals" + listOfString);
        return exchange1;
    }

    /*@GetMapping(path = "/api/auth/confirm")
    public String confirm(@RequestParam("token") String token) {

        curl --request POST 'https://storage.googleapis.com/storage/v1/b?project=[YOUR_PROJECT_ID]' \
        --header "Authorization: Bearer  [YOUR_ACCESS_TOKEN]" \

        return userManagmentService.confirmToken(token);

        curl -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJnVDdReVh3aklTZDJxaVZCUkRSTE5FNTQ0akltVEFWT25zb2Fpb0w5cU1NaGpWdWY3dSIsImp0aSI6IjUyNzRlYzZkMDgzMmI1YTFiODYzZTEyZDkzZjI5MjAzNDQ5Zjk5ZjZhMGQ4MDgwZjUzZjM5ZmQ3ZTFmZDU4YTYzMjdlZjkzY2EwODgwNzg0IiwiaWF0IjoxNjUwMTI0MDIyLCJuYmYiOjE2NTAxMjQwMjIsImV4cCI6MTY1MDEyNzYyMiwic3ViIjoiIiwic2NvcGVzIjpbXX0.X3YPbiZ1_oUSvTXSWZVR-0O72I2YRaIlM_0upbmqkqZ4IpKE0PlYmH85EKReT0ryn2IZON7UIHn26HiJ9vWIJ1vqG_5uGqYj3Z4_Ctdr6RIBFcS0rT1GJFs5L_Z5JCMDOfXOzcmXkWSdItcIuXFyhEV5y3yjcbxSU5gOYTYAn7TVb0uUm9bJANoC9PbS5-u3-7hyhxZ10LAxtpOyMv14oY8haA2EegP6Zi_bfDFY0tREgOqlliV_nsWO1fClGTu9Pkf2girnnOCjVS8jTm6atCwwxtNie-az3gLhl8VWALsWY3Bjq00bWRKwfXQdIbMguqeCX78sW5hQ8Qo1EKYk-A" GET https://api.petfinder.com/v2/animals


    }

    @GetMapping(path = "/api/auth/confirm")
    public ResponseEntity<?> getCountry() {
            try {
                HttpRequest request;
                request = HttpReques
                        .getMethod("https://countriesnow.space/api/v0.1/countries")
                        .connectTimeout(120000);
                HttpRequest httpRequest = new HttpRequest() {
                }
                String res = request.body();
                return new ResponseEntity<>(res, HttpStatus.OK);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<>("Error!, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
*/




}
