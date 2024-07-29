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
import com.openlab.edition.infras.repository.JpaEditeurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
//@SpringBootTest(classes = EditeurTest.class)
@ExtendWith(MockitoExtension.class)
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
    private JpaEditeurRepository jpaEditeurRepository;

    @InjectMocks
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


   @Test
    void findById() {
//given
       Editeur editeur = new Editeur();
       editeur.setId(1L);
       editeur.setName("Test Editeur");
       editeur.setEmail("editeur@test.com");

       //when
       when(jpaEditeurRepository.findById(1L)).thenReturn(Optional.of(editeur));

       Optional<Editeur> resultat = editeurRepositoryAdaptateur.findById(1L);

       //then
       assertTrue(resultat.isPresent());
       assertEquals("Test Editeur", resultat.get().getName());
       assertEquals("editeur@test.com", resultat.get().getEmail());
       verify(jpaEditeurRepository, times(1)).findById(1L);
   }


    @Test
    public void testValiderContenu(){

        //given
        Editeur editeur = new Editeur();
        editeur.setId(1L);
        Contenu contenu = new Article();

        contenu.setId(1L);
        editeur.setEmail("editeur@test.com");
        contenu.setTitle("Test Article");
        contenu.setContent("Ceci est un test.");
        contenu.setStatus(Status.NON_PUBLIE);

        Auteur auteur = new Auteur();
        contenu.setAuteur(auteur);

        //when
        when(editeurProvider.findById(anyLong())).thenReturn(Optional.of(editeur));
        when(contenuProvider.findById(anyLong())).thenReturn(Optional.of(contenu));

        editionService.validerContenu(1L, 1L);

        //then
        assertEquals(Status.PUBLIE, contenu.getStatus());
        verify(contenuProvider, times(1)).save(contenu);
        verify(emailService, times(1)).envoyerNotificationSansPieces(eq("editeur@test.com"), eq("Notification"), anyString());
    }

    @Test
    public void testRejeterContenu(){
        // given
        Editeur editeur = new Editeur();
        editeur.setId(1L);
        editeur.setEmail("editeur@test.com");
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
        assertEquals(Status.REJETE, contenu.getStatus());
        verify(contenuProvider, times(1)).save(contenu);
        verify(commentaireProvider, times(1)).save(any(Commentaire.class));
        verify(emailService, times(1)).envoyerNotificationSansPieces(eq("editeur@test.com"), eq("Notification"), anyString());
    }

}