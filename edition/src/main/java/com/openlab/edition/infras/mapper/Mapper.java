package com.openlab.edition.infras.mapper;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import com.openlab.edition.domaine.cours.model.Cours;
import com.openlab.edition.domaine.editeur.model.Editeur;
import com.openlab.edition.infras.dtos.*;
import com.openlab.edition.infras.entities.*;

public class Mapper {

    // Editeur mappings
    public static Editeur toDomain(EditeurEntity entity) {
        Editeur editeur = new Editeur();
        editeur.setId(entity.getId());
        editeur.setName(entity.getName());
        editeur.setEmail(entity.getEmail());
        return editeur;
    }

    public static EditeurEntity toEntity(Editeur editeur) {
        EditeurEntity entity = new EditeurEntity();
        entity.setId(editeur.getId());
        entity.setName(editeur.getName());
        entity.setEmail(editeur.getEmail());
        return entity;
    }

    public static EditeurDTO toDTO(Editeur editeur) {
        EditeurDTO dto = new EditeurDTO();
        dto.setId(editeur.getId());
        dto.setName(editeur.getName());
        dto.setEmail(editeur.getEmail());
        return dto;
    }

    public static Editeur toDomain(EditeurDTO dto) {
        Editeur editeur = new Editeur();
        editeur.setId(dto.getId());
        editeur.setName(dto.getName());
        editeur.setEmail(dto.getEmail());
        return editeur;
    }

    // Contenu mappings
    public static Contenu toDomain(ContenuEntity entity) {
        if (entity instanceof ArticleEntity) {
            return toDomain((ArticleEntity) entity);
        } else if (entity instanceof CoursEntity) {
            return toDomain((CoursEntity) entity);
        }
        return null;
    }

    public static ContenuEntity toEntity(Contenu contenu) {
        if (contenu instanceof Article) {
            return toEntity((Article) contenu);
        } else if (contenu instanceof Cours) {
            return toEntity((Cours) contenu);
        }
        return null;
    }

    // Article mappings
    public static Article toDomain(ArticleEntity entity) {
        Article article = new Article();
        article.setId(entity.getId());
        article.setTitle(entity.getTitle());
        article.setContent(entity.getContent());
        article.setStatus(entity.getStatus());
        return article;
    }

    public static ArticleEntity toEntity(Article article) {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(article.getId());
        entity.setTitle(article.getTitle());
        entity.setContent(article.getContent());
        entity.setStatus(article.getStatus());
        return entity;
    }

    public static ArticleDTO toDTO(Article article) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setContent(article.getContent());
        dto.setStatus(article.getStatus());
        //dto.setAuteurId(article.getId());
       // dto.setNbrVues(article.getNbrVues());
        return dto;
    }

    public static Article toDomain(ArticleDTO dto) {
        Article article = new Article();
        article.setId(dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setStatus(dto.getStatus());
        article.setAuteur(null);
        return article;
    }

    // Cours mappings
    public static Cours toDomain(CoursEntity entity) {
        Cours cours = new Cours();
        cours.setId(entity.getId());
        cours.setTitle(entity.getTitle());
        cours.setDescription(entity.getDescription());

        return cours;
    }

    public static CoursEntity toEntity(Cours cours) {
        CoursEntity entity = new CoursEntity();
        entity.setId(cours.getId());
        entity.setTitle(cours.getTitle());
        entity.setDescription(cours.getDescription());
        return entity;
    }

    public static CoursDTO toDTO(Cours cours) {
        CoursDTO dto = new CoursDTO();
        dto.setId(cours.getId());
        dto.setTitle(cours.getTitle());
        dto.setDescription(cours.getDescription());
        return dto;
    }

    public static Cours toDomain(CoursDTO dto) {
        Cours cours = new Cours();
        cours.setId(dto.getId());
        cours.setTitle(dto.getTitle());
        cours.setDescription(dto.getDescription());
        return cours;
    }

    // Auteur mappings
    public static Auteur toDomain(AuteurEntity entity) {
        Auteur auteur = new Auteur();
        auteur.setId(entity.getId());
        auteur.setName(entity.getName());
        return auteur;
    }

    public static AuteurEntity toEntity(Auteur auteur) {
        AuteurEntity entity = new AuteurEntity();
        entity.setId(auteur.getId());
        entity.setName(auteur.getName());
        return entity;
    }

    public static AuteurDTO toDTO(Auteur auteur) {
        AuteurDTO dto = new AuteurDTO();
        dto.setId(auteur.getId());
        dto.setName(auteur.getName());
        return dto;
    }

    public static Auteur toDomain(AuteurDTO dto) {
        Auteur auteur = new Auteur();
        auteur.setId(dto.getId());
        auteur.setName(dto.getName());
        return auteur;
    }

    // Commentaire mappings
    public static Commentaire toDomain(CommentaireDTO dto) {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(dto.getId());
        commentaire.setContenuId(dto.getContenuId());
        commentaire.setTexte(dto.getTexte());
        commentaire.setAuteurId(dto.getAuteurId());
        commentaire.setDateCreation(dto.getDateCreation());
        return commentaire;
    }

    public static CommentaireDTO toDTO(Commentaire commentaire) {
        CommentaireDTO dto = new CommentaireDTO();
        dto.setId(commentaire.getId());
        dto.setContenuId(commentaire.getContenuId());
        dto.setTexte(commentaire.getTexte());
        dto.setAuteurId(commentaire.getAuteurId());
        dto.setDateCreation(commentaire.getDateCreation());
        return dto;
    }

    public static Commentaire toDomain(CommentaireEntity entity) {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(entity.getId());
        commentaire.setContenuId(entity.getContenuId());
        commentaire.setTexte(entity.getTexte());
        commentaire.setAuteurId(entity.getAuteurId());
        commentaire.setDateCreation(entity.getDateCreation());
        return commentaire;
    }

    public static CommentaireEntity toEntity(Commentaire commentaire) {
        CommentaireEntity entity = new CommentaireEntity();
        entity.setId(commentaire.getId());
        entity.setContenuId(commentaire.getContenuId());
        entity.setTexte(commentaire.getTexte());
        entity.setAuteurId(commentaire.getAuteurId());
        entity.setDateCreation(commentaire.getDateCreation());
        return entity;
    }

    public static ContenuDTO toDTO(Contenu contenu) {
        if (contenu instanceof Article) {
            return toDTO((Article) contenu);
        } else if (contenu instanceof Cours) {
            return toDTO((Cours) contenu);
        }
        return null;
    }

    public static Contenu toDomain(ContenuDTO dto) {
        if (dto instanceof ArticleDTO) {
            return toDomain((ArticleDTO) dto);
        } else if (dto instanceof CoursDTO) {
            return toDomain((CoursDTO) dto);
        }
        return null;
    }
}
