package com.openlab.edition.infras.adaptateurs;

import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.infras.entities.ArticleEntity;
import com.openlab.edition.infras.entities.ContenuEntity;
import com.openlab.edition.infras.entities.CoursEntity;
import com.openlab.edition.infras.mapper.Mapper;
import com.openlab.edition.infras.repository.JpaContenuRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContenuRepositoryAdaptateur implements ContenuProvider {

    private final JpaContenuRepository jpaContenuRepository;

    public ContenuRepositoryAdaptateur(JpaContenuRepository jpaContenuRepository) {
        this.jpaContenuRepository = jpaContenuRepository;
    }

    @Override
    public Contenu save(Contenu contenu) {
        ContenuEntity entity = Mapper.toEntity(contenu);
        if(entity instanceof ArticleEntity){
            return Mapper.toDomain(jpaContenuRepository.save((ArticleEntity)entity));
        } else if (entity instanceof CoursEntity) {
            return Mapper.toDomain(jpaContenuRepository.save((CoursEntity)entity));

        }
        return null;
    }

    @Override
    public Optional<Contenu> findById(Long id) {
        return jpaContenuRepository.findById(id).map(Mapper::toDomain);
    }

}