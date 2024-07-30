package com.openlab.edition.infras.controllers;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.infras.adaptateurs.ContenuRepositoryAdaptateur;
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


    @PostMapping
    public ResponseEntity<Contenu> createContenu(@RequestBody Contenu contenu) {
        Contenu savedContenu = contenuRepositoryAdaptateur.save(contenu);
        return ResponseEntity.ok(savedContenu);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenu> getContenuById(@PathVariable Long id) {
        Optional<Contenu> contenu = contenuRepositoryAdaptateur.findById(id);
        return contenu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
