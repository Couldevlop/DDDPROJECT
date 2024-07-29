package com.openlab.edition.infras.repository;

import com.openlab.edition.domaine.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaContenuRepository extends JpaRepository<Contenu, Long>{
}
