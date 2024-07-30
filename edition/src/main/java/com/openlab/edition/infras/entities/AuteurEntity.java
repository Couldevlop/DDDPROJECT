package com.openlab.edition.infras.entities;



import com.openlab.edition.domaine.article.ArticleProvider;
import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.auteur.Skills;
import com.openlab.edition.domaine.cours.CoursProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuteurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<Skills> skills;
    private String name;
    private String email;


}
