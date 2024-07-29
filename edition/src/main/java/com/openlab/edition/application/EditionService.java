package com.openlab.edition.application;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.article.Status;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import com.openlab.edition.domaine.cours.model.Cours;
import com.openlab.edition.domaine.editeur.EditeurProvider;
import com.openlab.edition.domaine.editeur.model.Editeur;
import com.openlab.edition.infras.config.EmailService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EditionService {
    private final AuteurProvider auteurProvider;
    private final ContenuProvider contenuProvider;
    private final CommentaireProvider commentaireProvider;
    private final EmailService emailService;
    private final EditeurProvider editeurProvider;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public EditionService(AuteurProvider auteurProvider, ContenuProvider contenuProvider, CommentaireProvider commentaireProvider, EmailService emailService, EditeurProvider editeurProvider,
                          KafkaTemplate<String, String> kafkaTemplate) {
        this.auteurProvider = auteurProvider;
        this.contenuProvider = contenuProvider;
        this.commentaireProvider = commentaireProvider;
        this.editeurProvider = editeurProvider;
        this.kafkaTemplate = kafkaTemplate;
        this.emailService = emailService;
    }

    public void createEditeur(Editeur editeur){
        editeur.register(editeurProvider);
    }


    public void createArticle(Article article){
        article.register(contenuProvider);
        kafkaTemplate.send("contenu-a-etudier", article.getId().toString());
    }


    public void createCours(Cours cours){
        if(cours.verifySkillsAuteur()){
            cours.register(contenuProvider);
            kafkaTemplate.send("contenu-a-etudier", cours.getId().toString());
        }else {
            throw new IllegalArgumentException("L'auteur ne possède pas les competences necessaires pour écrire ce cours");
        }
    }


    public void validerContenu(Long editeurId, Long contenuId){
        Editeur editeur = Editeur.findById(editeurProvider, editeurId).orElseThrow();
        Contenu contenu = Contenu.findById(contenuProvider, contenuId).orElseThrow();
        editeur.validerContenu(contenuProvider, contenu);
        editeur.notifierAuteur(emailService, contenu.getAuteur().getEmail(),  "Votre contenu a été rejeté : ");
    }


    public void commenterContenu(Long contenuId, Commentaire commentaire){
        Contenu contenu = Contenu.findById(contenuProvider, contenuId).orElseThrow();
        contenu.commenter(commentaireProvider, commentaire);
    }

    public void rejeterContenu(Long editeurId, Long contenuId, String commentaire) {
        Editeur editeur = Editeur.findById(editeurProvider, editeurId).orElseThrow();
        Contenu contenu = Contenu.findById(contenuProvider, contenuId).orElseThrow();
        editeur.rejeterContenu(contenuProvider, contenu, commentaire, commentaireProvider);
        editeur.notifierAuteur(emailService, contenu.getAuteur().getEmail(), "Votre contenu a été rejeté : " + commentaire);
    }


}
