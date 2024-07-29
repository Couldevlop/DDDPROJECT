package com.openlab.edition.infras.adaptateurs;

import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.infras.repository.JpaContenuRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContenuRepositoryAdaptateur implements ContenuProvider {

    private final JpaContenuRepository jpaContenuRepository;

    public ContenuRepositoryAdaptateur(JpaContenuRepository jpaContenuRepository) {
        this.jpaContenuRepository = jpaContenuRepository;
    }

    @Override
    public Contenu save(Contenu content) {
        return jpaContenuRepository.save(content);
    }

    @Override
    public Optional<Contenu> findById(long id) {
        return jpaContenuRepository.findById(id);
    }

}