package com.openlab.edition.infras.controllers;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.cours.model.Cours;
import com.openlab.edition.infras.adaptateurs.ContenuRepositoryAdaptateur;
import com.openlab.edition.infras.dtos.ArticleDTO;
import com.openlab.edition.infras.dtos.ContenuDTO;
import com.openlab.edition.infras.dtos.CoursDTO;
import com.openlab.edition.infras.entities.ContenuEntity;
import com.openlab.edition.infras.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/contenu")
public class ContenuController {

    private final ContenuRepositoryAdaptateur contenuRepositoryAdaptateur;

    public ContenuController(ContenuRepositoryAdaptateur contenuRepositoryAdaptateur) {
        this.contenuRepositoryAdaptateur = contenuRepositoryAdaptateur;
    }


    @PostMapping("/article")
    public ResponseEntity<ArticleDTO> createContenuArticle(@RequestBody Contenu contenu) {
        Contenu savedContenu = contenuRepositoryAdaptateur.save(contenu);
        return ResponseEntity.ok((ArticleDTO) Mapper.toDTO(savedContenu));
    }


    @PostMapping("/cours")
    public ResponseEntity<CoursDTO> createContenuCours(@RequestBody Contenu contenu) {
        Contenu savedContenu = contenuRepositoryAdaptateur.save(contenu);
        return ResponseEntity.ok((CoursDTO) Mapper.toDTO(savedContenu));
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<ContenuEntity> getContenuById(@PathVariable Long id) {
        Optional<Contenu> contenu = contenuRepositoryAdaptateur.findById(id);
        return contenu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }*/


    @GetMapping("/{id}")
    public ResponseEntity<?> getContenu(@PathVariable Long id){
        Optional<Contenu> contenu = contenuRepositoryAdaptateur.findById(id);
        if(contenu.isPresent()){
            if(contenu.get() instanceof Article){
                return ResponseEntity.ok(Mapper.toDTO((Article) contenu.get()) );
            } else if (contenu.get() instanceof Cours) {
                return ResponseEntity.ok(Mapper.toDTO((Cours) contenu.get()));
            }
        }

     return ResponseEntity.notFound().build();
    }



}
