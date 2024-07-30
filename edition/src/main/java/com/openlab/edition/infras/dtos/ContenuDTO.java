package com.openlab.edition.infras.dtos;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ArticleDTO.class, name = "article")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class ContenuDTO {
    private Long id;
    private String title;
    private String content;
    private String status;
    private Long auteurId;

    // Getters and setters
}
