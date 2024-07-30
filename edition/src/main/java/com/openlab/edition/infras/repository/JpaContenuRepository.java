package com.openlab.edition.infras.repository;


import com.openlab.edition.infras.entities.ContenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaContenuRepository extends JpaRepository<ContenuEntity, Long> {
}
