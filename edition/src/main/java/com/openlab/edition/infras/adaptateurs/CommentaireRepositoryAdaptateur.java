package com.openlab.edition.infras.adaptateurs;

import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import com.openlab.edition.infras.entities.CommentaireEntity;
import com.openlab.edition.infras.mapper.Mapper;
import com.openlab.edition.infras.repository.JpaCommentaireRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentaireRepositoryAdaptateur implements CommentaireProvider {


    private final JpaCommentaireRepository jpaCommentaireRepository;

    public CommentaireRepositoryAdaptateur(JpaCommentaireRepository jpaCommentaireRepository) {
        this.jpaCommentaireRepository = jpaCommentaireRepository;
    }

    @Override
    public Commentaire save(Commentaire commentaire) {
        CommentaireEntity entity = Mapper.toEntity(commentaire);
        return Mapper.toDomain(jpaCommentaireRepository.save(entity));
    }

    @Override
    public Optional<Commentaire> findById(Long id) {
        return jpaCommentaireRepository.findById(id).map(Mapper::toDomain);
    }
}
