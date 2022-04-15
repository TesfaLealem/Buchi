package com.yet.buchi.DTOs.ResponseDTOs;

import com.yet.buchi.Utilities.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAdoptionOut {
    private Long adoptionId;
    private Status status;
}
