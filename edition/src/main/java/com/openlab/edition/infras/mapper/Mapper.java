package com.openlab.edition.infras.mapper;
import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.article.Status;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import com.openlab.edition.domaine.editeur.model.Editeur;
import com.openlab.edition.infras.dtos.*;
import com.openlab.edition.infras.entities.*;

public class Mapper {
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

    public static Contenu toDomain(ContenuEntity entity) {
        if (entity instanceof ArticleEntity) {
            Article article = new Article();
            article.setId(entity.getId());
            article.setTitle(entity.getTitle());
            article.setContent(entity.getContent());
            article.setStatus(entity.getStatus());
            return article;
        }
        return null;
    }

    public static ContenuEntity toEntity(Contenu contenu) {
        if (contenu instanceof Article) {
            ArticleEntity entity = new ArticleEntity();
            entity.setId(contenu.getId());
            entity.setTitle(contenu.getTitle());
            entity.setContent(contenu.getContent());
            entity.setStatus(contenu.getStatus());
            return entity;
        }
        return null;
    }

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
    public static CommentaireEntity toEntity(Commentaire commentaire) {
        CommentaireEntity entity = new CommentaireEntity();
        entity.setId(commentaire.getId());
        entity.setAuteur(commentaire.getAuteur());
        entity.setContenu(commentaire.getContenu());
        entity.setTexte(commentaire.getTexte());
        return entity;
    }

    public static Commentaire toDomain(CommentaireEntity entity) {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(entity.getId());
        commentaire.setAuteur(entity.getAuteur());
        commentaire.setTexte(entity.getTexte());
        commentaire.setContenu(entity.getContenu());
        return commentaire;
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

    public static ContenuDTO toDTO(Contenu contenu) {
        if (contenu instanceof Article) {
            ArticleDTO dto = new ArticleDTO();
            dto.setId(contenu.getId());
            dto.setTitle(contenu.getTitle());
            dto.setContent(contenu.getContent());
            dto.setStatus(contenu.getStatus().name());
            return dto;
        }
        return null;
    }

    public static Contenu toDomain(ContenuDTO dto) {
        if (dto instanceof ArticleDTO) {
            Article article = new Article();
            article.setId(dto.getId());
            article.setTitle(dto.getTitle());
            article.setContent(dto.getContent());
            article.setStatus(Status.valueOf(dto.getStatus()));
            return article;
        }
        return null;
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




}
