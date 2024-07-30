package com.openlab.edition.infras.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditeurDTO {
    private Long id;
    private String name;
    private String email;

    // Getters and setters
}
