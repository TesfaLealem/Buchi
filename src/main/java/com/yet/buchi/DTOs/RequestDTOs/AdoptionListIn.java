package com.yet.buchi.DTOs.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdoptionListIn {
    private Date startDate;
    private Date endDate;
}
