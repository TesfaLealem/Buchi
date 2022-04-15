package com.yet.buchi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pet")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String type;

    @NotBlank
    @Size(max = 255)
    private String gender;

    @NotBlank
    @Size(max = 255)
    private String size;

    @NotBlank
    @Size(max = 255)
    private String age;

    @NotBlank
    @Size(max = 255)
    private String picturePath;

    private boolean goodWithChildren;

}
