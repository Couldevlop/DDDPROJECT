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
public class ArticleDTO extends ContenuDTO {
    // Champs spécifiques à ArticleDTO
}

