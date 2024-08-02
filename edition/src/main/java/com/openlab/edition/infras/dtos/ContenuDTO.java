package com.openlab.edition.infras.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.openlab.edition.domaine.article.Status;
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
    private Status status;
    private String domaine;
    private int nbrVues;
    @JsonIgnore
    private Long auteurId;

    // Getters and setters
}
