package com.openlab.edition.infras.adaptateurs;

import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.Contenu;
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
    public Contenu save(Contenu content) {
        return jpaContenuRepository.save(content);
    }

    @Override
    public Optional<Contenu> findById(Long id) {
        return jpaContenuRepository.findById(id);
    }

}