package com.openlab.edition.infras.adaptateurs;

import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import com.openlab.edition.infras.repository.JpaCommentaireRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CommentaireRepositoryAdaptateur implements CommentaireProvider {


    private final JpaCommentaireRepository jpaCommentaireRepository;

    public CommentaireRepositoryAdaptateur(JpaCommentaireRepository jpaCommentaireRepository) {
        this.jpaCommentaireRepository = jpaCommentaireRepository;
    }

    @Override
    public Commentaire save(Commentaire commentaire) {
        return jpaCommentaireRepository.save(commentaire);
    }

    @Override
    public Optional<Commentaire> findById(Long id) {
        return jpaCommentaireRepository.findById(id);
    }
}
