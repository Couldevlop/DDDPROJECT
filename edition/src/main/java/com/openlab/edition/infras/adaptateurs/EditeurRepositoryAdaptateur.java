package com.openlab.edition.infras.adaptateurs;

import com.openlab.edition.domaine.editeur.EditeurProvider;
import com.openlab.edition.domaine.editeur.model.Editeur;
import com.openlab.edition.infras.repository.JpaEditeurRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class EditeurRepositoryAdaptateur implements EditeurProvider {


    private final JpaEditeurRepository jpaEditeurRepository;

    public EditeurRepositoryAdaptateur(JpaEditeurRepository jpaEditeurRepository) {
        this.jpaEditeurRepository = jpaEditeurRepository;
    }

    @Override
    public Editeur save(Editeur editeur) {
        return jpaEditeurRepository.save(editeur);
    }

    @Override
    public Optional<Editeur> findById(Long id) {
        return jpaEditeurRepository.findById(id);
    }
}
