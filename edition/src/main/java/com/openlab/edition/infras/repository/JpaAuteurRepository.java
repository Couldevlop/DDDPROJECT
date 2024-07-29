package com.openlab.edition.infras.repository;

import com.openlab.edition.domaine.auteur.model.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAuteurRepository extends JpaRepository<Auteur, Long> {
}
