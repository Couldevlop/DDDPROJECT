package com.openlab.edition.domaine.editeur.model;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.article.Status;
import com.openlab.edition.domaine.auteur.Skills;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import com.openlab.edition.domaine.editeur.EditeurProvider;
import com.openlab.edition.infras.config.EmailService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Editeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    //private List<Skills> skills;


public Editeur register(EditeurProvider editeurProvider){
    return editeurProvider.save(this);
}

public static Optional<Editeur> findById(EditeurProvider editeurProvider, Long id){
    return editeurProvider.findById(id);
}
    public void validerContenu(ContenuProvider contenuProvider, Contenu contenu) {
        contenu.setStatus(Status.PUBLIE);
        contenu.register(contenuProvider);
    }

    public void rejeterContenu(ContenuProvider contenuProvider, Contenu contenu, String commentaire, CommentaireProvider commentaireProvider) {
        contenu.setStatus(Status.NON_PUBLIE);
        contenu.register(contenuProvider);

        Commentaire rejectionCommentaire = new Commentaire();
        rejectionCommentaire.setTexte(commentaire);
        rejectionCommentaire.setAuteur(contenu.getAuteur());
        rejectionCommentaire.setContenu(contenu);
        rejectionCommentaire.register(commentaireProvider);
    }

    public void notifierAuteur(EmailService emailService, String email, String message) {
        emailService.envoyerNotificationSansPieces(this.email,"Notification", message);
    }
}
