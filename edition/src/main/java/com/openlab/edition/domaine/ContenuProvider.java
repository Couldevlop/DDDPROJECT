package com.openlab.edition.domaine;



import java.util.Optional;

public interface ContenuProvider {
    Contenu save(Contenu content);
    Optional<Contenu> findById(Long id);
}
