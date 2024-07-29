package com.openlab.edition.infras.controllers;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.ContenuProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/contenu")
public class ContenuController {

    private final ContenuProvider contenuProvider;

    public ContenuController(ContenuProvider contenuProvider) {
        this.contenuProvider = contenuProvider;
    }

    @PostMapping
    public ResponseEntity<Contenu> createContenu(@RequestBody Contenu contenu) {
        Contenu savedContenu = contenuProvider.save(contenu);
        return ResponseEntity.ok(savedContenu);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenu> getContenuById(@PathVariable Long id) {
        Optional<Contenu> contenu = contenuProvider.findById(id);
        return contenu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
