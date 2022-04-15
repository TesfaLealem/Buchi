package com.yet.buchi.DTOs.ResponseDTOs;


import com.yet.buchi.Utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPetOut {

    private Long petId;
    private Status status;


}
