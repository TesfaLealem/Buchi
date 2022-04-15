package com.yet.buchi.DTOs.RestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionDto {

    private Long customerId;
    private String phone;
    private String customerName;
    private Long petId;
    private String type;
    private String gender;
    private String size;
    private String age;
    private boolean goodWithChildren;

}
