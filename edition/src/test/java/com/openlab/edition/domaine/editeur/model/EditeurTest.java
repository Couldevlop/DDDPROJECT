package com.openlab.edition.domaine.editeur.model;


import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.editeur.EditeurProvider;
import com.openlab.edition.infras.adaptateurs.EditeurRepositoryAdaptateur;
import com.openlab.edition.infras.config.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest(classes = EditeurTest.class)
class EditeurTest {
    @Mock
    private  EditeurProvider editeurProvider;
    @Mock
    private ContenuProvider contenuProvider;
    @Mock
    private AuteurProvider auteurProvider;

    @Mock
    private CommentaireProvider commentaireProvider;

    @Mock
    private EmailService emailService;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;


    @Mock
    private EditeurRepositoryAdaptateur editeurRepositoryAdaptateur;

    @Test
    void register() {

        //given

        // Création de l'éditeur
        Editeur editeur = new Editeur();
        editeur.setName("Test Editeur");
        editeur.setEmail("editeur@test.com");


        when(editeurProvider.save(any(Editeur.class))).thenReturn(editeur);

        // Appel de la méthode de création de l'éditeur
        Editeur resultat = editeurRepositoryAdaptateur.save(editeur);

        // Vérifications
        assertEquals("Test Editeur", editeur.getName());
        assertEquals("editeur@test.com", editeur.getEmail());

    }


    @Test
    void findById() {
    }
}