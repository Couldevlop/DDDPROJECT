package com.openlab.edition.infras.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoursDTO extends ContenuDTO {
    private String niveau;
    private String description;
    private String subject;

    // Getters and setters
}