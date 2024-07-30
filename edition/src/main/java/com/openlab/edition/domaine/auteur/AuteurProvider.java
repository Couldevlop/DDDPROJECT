package com.openlab.edition.domaine.auteur;

import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.cours.model.Cours;

import java.util.Optional;

public interface AuteurProvider {
   Auteur save(Auteur auteur);
   Optional<Auteur> findById(long id);
   public Article redigerArticle(Article article);

   public Cours redigerCours(Cours cours);
}
