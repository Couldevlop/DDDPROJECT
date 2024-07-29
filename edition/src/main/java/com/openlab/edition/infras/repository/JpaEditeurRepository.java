package com.openlab.edition.infras.repository;

import com.openlab.edition.domaine.editeur.model.Editeur;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JpaEditeurRepository extends JpaRepository<Editeur, Long> {
}
