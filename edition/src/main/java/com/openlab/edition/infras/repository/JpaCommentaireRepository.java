package com.openlab.edition.infras.repository;


import com.openlab.edition.infras.entities.CommentaireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentaireRepository extends JpaRepository<CommentaireEntity, Long> {
}
