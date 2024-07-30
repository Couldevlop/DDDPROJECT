package com.openlab.edition.infras.repository;


import com.openlab.edition.infras.entities.EditeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JpaEditeurRepository extends JpaRepository<EditeurEntity, Long> {
}
