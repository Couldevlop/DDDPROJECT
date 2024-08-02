package com.openlab.edition.infras.controllers;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.article.model.Article;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.cours.model.Cours;
import com.openlab.edition.infras.adaptateurs.AuteurRepositoryAdaptateur;
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
    private final AuteurRepositoryAdaptateur auteurRepositoryAdaptateur;

    public ContenuController(ContenuRepositoryAdaptateur contenuRepositoryAdaptateur, AuteurRepositoryAdaptateur auteurRepositoryAdaptateur) {
        this.contenuRepositoryAdaptateur = contenuRepositoryAdaptateur;
        this.auteurRepositoryAdaptateur = auteurRepositoryAdaptateur;
    }


    @PostMapping("/article")
    public ResponseEntity<ArticleDTO> createContenuArticle(@RequestBody ArticleDTO articleDTO, @RequestParam Long auteurId) {
        Contenu article = Mapper.toDomain(articleDTO);
        Optional<Auteur> auteur = auteurRepositoryAdaptateur.findById(auteurId);
        auteur.ifPresent(article::setAuteur);
        Contenu savedContenu = contenuRepositoryAdaptateur.save(article);

        return ResponseEntity.ok((ArticleDTO) Mapper.toDTO(savedContenu));
    }

    @PostMapping("/cours")
    public ResponseEntity<CoursDTO> createContenuCours(@RequestBody CoursDTO coursDTO) {
        Contenu cours = Mapper.toDomain(coursDTO);
        Contenu savedContenu = contenuRepositoryAdaptateur.save(cours);
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
