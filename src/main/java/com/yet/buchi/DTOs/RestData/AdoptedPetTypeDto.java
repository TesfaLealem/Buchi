package com.yet.buchi.DTOs.RestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptedPetTypeDto {

    private String cat;
    private String dog;
}
