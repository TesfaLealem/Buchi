package com.yet.buchi.DTOs.RequestDTOs;

import com.yet.buchi.DTOs.RestData.AdoptionDto;
import com.yet.buchi.Utilities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdoptionListDto {
    private List<AdoptionDto> adoptionDtos;
    private long count;
    private Status status;
}
