package com.openlab.edition.domaine.auteur.model;



import com.openlab.edition.domaine.article.ArticleProvider;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.auteur.Skills;
import com.openlab.edition.domaine.cours.CoursProvider;
import com.openlab.edition.domaine.cours.model.Cours;
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
public class Auteur {
    private Long id;
    @ElementCollection
    private List<Skills> skills;
    private String name;
    private String email;



    public Auteur register(AuteurProvider auteurProvider){
        return auteurProvider.save(this);
    }

    public static Optional<Auteur> findById(AuteurProvider auteurProvider, Long id){
        return auteurProvider.findById(id);
    }

    public Article redigerArticle(ArticleProvider articleProvider, Article article1){

        Article article = new Article();
        article.setContent(article1.getContent());
        article.setTitle(article1.getTitle());
        article.setContent(article1.getContent());
        article.setAuteur(this);
        return articleProvider.register(article);
    }


    public Cours redigerCours(CoursProvider coursProvider, Cours cours1){
     Cours cours = new Cours();
     cours.setTitle(cours1.getTitle());
     cours.setDomaine(cours1.getDomaine());
     cours.setAuteur(cours1.getAuteur());
        return coursProvider.save(cours);
    }

   /* public void soumettre() {
        this.status = Status.SOUMIS;
        // Publier un événement de soumission de contenu
        // KafkaProducer.publish(new ContenuSubmittedEvent(this));
    }*/


}
