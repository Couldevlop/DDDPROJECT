package com.openlab.edition.domaine.editeur.model;


import com.openlab.edition.application.EditionService;
import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.article.Status;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import com.openlab.edition.domaine.editeur.EditeurProvider;
import com.openlab.edition.infras.adaptateurs.EditeurRepositoryAdaptateur;
import com.openlab.edition.infras.config.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Optional;

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

    @InjectMocks
    private EditionService editionService;

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


   /* @Test
    void findById() {


        //given
        Editeur editeur = new Editeur();
        editeur.setId(1L);
        editeur.setName("HORIZON");
        editeur.setEmail("horizon@gmail.com");


        //when
        when(editeurProvider.findById(anyLong())).thenReturn(Optional.of(editeur));
        editeurRepositoryAdaptateur.findById(editeur.getId());

        // then
        verify(editeurProvider, times(1)).findById(anyLong());
    }*/

    @Test
    public void testValiderContenu(){

        //given
        Editeur editeur = new Editeur();
        editeur.setId(1L);
        Contenu contenu = new Article();

        contenu.setId(1L);
        contenu.setTitle("Test Article");
        contenu.setContent("Ceci est un test.");
        contenu.setStatus(Status.PUBLIE);

        Auteur auteur = new Auteur();
        contenu.setAuteur(auteur);

        //when
        when(editeurProvider.findById(anyLong())).thenReturn(Optional.of(editeur));
        when(contenuProvider.findById(anyLong())).thenReturn(Optional.of(contenu));

        editionService.validerContenu(1L, 1L);

        //Then
        assertEquals("PUBLIE", contenu.getStatus());
        verify(contenuProvider, times(1)).save(contenu);
        verify(emailService, times(1)).envoyerNotificationSansPieces(anyString(), anyString(),anyString());
    }

    @Test
    public void testRejeterContenu(){
        // given
        Editeur editeur = new Editeur();
        editeur.setId(1L);
        editeur.setEmail("coulwao@gmail.com");
        editeur.setName("HORIZON");

        Contenu contenu = new Article();
        contenu.setTitle("Test Article");
        contenu.setId(1L);
        contenu.setStatus(Status.REJETE);
        Auteur auteur = new Auteur();
        contenu.setAuteur(auteur);

        //when
        when(editeurProvider.findById(anyLong())).thenReturn(Optional.of(editeur));
        when(contenuProvider.findById(anyLong())).thenReturn(Optional.of(contenu));

        editionService.rejeterContenu(1L, 1L,"Votre contenu manque d'originalité.");

        //Then
        assertEquals("REJETE", contenu.getStatus());
        verify(contenuProvider, times(1)).save(contenu);
        verify(commentaireProvider, times(1)).save(any(Commentaire.class));
        verify(emailService, times(1)).envoyerNotificationSansPieces(anyString(),anyString(),anyString());
    }

}