package com.openlab.edition.infras.adaptateurs;

import com.openlab.edition.domaine.article.model.Article;

import com.openlab.edition.domaine.auteur.AuteurProvider;

import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.cours.model.Cours;

import com.openlab.edition.infras.entities.AuteurEntity;
import com.openlab.edition.infras.mapper.Mapper;
import com.openlab.edition.infras.repository.JpaAuteurRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuteurRepositoryAdaptateur implements AuteurProvider {


    private final JpaAuteurRepository jpaAuteurRepository;

    public AuteurRepositoryAdaptateur(JpaAuteurRepository jpaAuteurRepository) {
        this.jpaAuteurRepository = jpaAuteurRepository;
    }


    @Override
    public Auteur save(Auteur auteur) {
        AuteurEntity entity = Mapper.toEntity(auteur);
        return Mapper.toDomain(jpaAuteurRepository.save(entity));
    }

    @Override
    public Optional<Auteur> findById(long id) {
        return jpaAuteurRepository.findById(id).map(Mapper::toDomain);
    }

    @Override
    public Article redigerArticle(Article article) {
        return null;
    }

    @Override
    public Cours redigerCours(Cours cours) {
        return null;
    }


}
