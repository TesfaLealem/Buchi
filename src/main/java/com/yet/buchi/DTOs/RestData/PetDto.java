package com.yet.buchi.DTOs.RestData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {

    private Long id;
    private String type;
    private String source;
    private String gender;
    private String size;
    private String age;
    private String picturePath;
    private boolean goodWithChildren;

}
