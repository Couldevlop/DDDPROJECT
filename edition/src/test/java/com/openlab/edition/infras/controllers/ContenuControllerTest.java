package com.openlab.edition.infras.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.Skills;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.cours.model.Cours;
import com.openlab.edition.infras.adaptateurs.ContenuRepositoryAdaptateur;
import com.openlab.edition.infras.dtos.ArticleDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@WebMvcTest
//@SpringBootTest(classes = ContenuControllerTest.class)
class ContenuControllerTest {

    @Mock
    private MockMvc mockMvc;

    @MockBean
    private ContenuRepositoryAdaptateur contenuRepositoryAdaptateur;

    @Autowired
    private ObjectMapper objectMapper;
    private Article article;

    @BeforeEach
   public void setUp() {
        // artclie

        article = new Article();
        article.setId(1L);
        article.setContent("voici un contenu");
        article.setTitle("Informatique");
        article.setAuteur(new Auteur(1L, List.of(new Skills(1,"Physque", "8 ans")), "Thomas","coulwao@gmail.com"));
        article.setNbrVues(1);


        // Cours

        Cours cours = new Cours();
        cours.setId(1L);
        cours.setContent("voici un contenu");
        cours.setTitle("Ecologie");
        cours.setAuteur(new Auteur(1L, List.of(new Skills(1,"Botanique", "8 ans")), "Thomas","coulwao@gmail.com"));
        cours.setNbrVues(1);
        cours.setDomaine("nature");
        cours.setSubject("Sciences naturel");
    }

   /* @Test
    public void createContenuArticle() {
        //given
        ArticleDTO articleDTO = new ArticleDTO();
        // when
        // 2- on passe l'objet au service pour l'enregistrer dans la bd et on retourne l'objet
        when(contenuRepositoryAdaptateur.save(any(Article.class))).thenReturn(article);
        mockMvc.perform(post("/api/contenus/articles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(articleDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(articleDTO)));//then
        // -3 on verifie que l'objet retourné n'est pas nul
        // 4- on verifie l'égalité de certains élements de l'objet retourné
    }*/

    @Test
    void createContenuCours() {
    }

    @Test
    void getContenu() {
    }
}