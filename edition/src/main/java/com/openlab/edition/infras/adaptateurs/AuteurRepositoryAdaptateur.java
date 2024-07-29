package com.openlab.edition.infras.adaptateurs;

import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.infras.repository.JpaAuteurRepository;
import org.springframework.stereotype.Component;
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
        return  jpaAuteurRepository.save(auteur);
    }

    @Override
    public Optional<Auteur> findById(long id) {
        return jpaAuteurRepository.findById(id);
    }
}
