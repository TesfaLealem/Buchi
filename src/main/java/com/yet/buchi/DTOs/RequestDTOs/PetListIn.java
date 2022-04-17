package com.yet.buchi.DTOs.RequestDTOs;

import com.yet.buchi.DTOs.RestData.PetDto;
import com.yet.buchi.Utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetListIn {

    private String type;
//    private String gender;
//    private String size;
//    private String age;
//    private boolean goodWithChildren;
    private int limit;
}
