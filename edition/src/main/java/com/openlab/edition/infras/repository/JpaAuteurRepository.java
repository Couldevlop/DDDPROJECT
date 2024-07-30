package com.openlab.edition.infras.repository;


import com.openlab.edition.infras.entities.AuteurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAuteurRepository extends JpaRepository<AuteurEntity, Long> {
}
