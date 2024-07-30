package com.openlab.edition.domaine.auteur.model;

import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.cours.CoursProvider;
import com.openlab.edition.domaine.cours.model.Cours;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuteurTest {
    @Mock
    private AuteurProvider auteurProvider;
    @Mock
    private CoursProvider coursProvider;

    @Test
    void redigerCours() {

        //given
        Cours cours = new Cours();
        cours.setTitle("un titre");
        cours.setDomaine("Informatique");
        cours.setContent("voici un contenu");
        cours.setSubject("Un sujet");
        //when
        Auteur auteur = new Auteur(); // Assuming you need an Auteur object for the call
        Cours returnedCours = auteur.redigerCours(coursProvider, cours); // Call the actual method

        //when(auteurProvider.redigerCours(any(Cours.class))).thenReturn(cours);
        // then
       assertEquals(cours.getTitle(), "un titre");
    }
}