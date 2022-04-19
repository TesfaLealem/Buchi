package com.yet.buchi.DTOs.RestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeeklyAdoptionRequestDto {

    private String week1;
    private String week2;
    private String week3;
    private String week4;

}
