package com.openlab.edition.infras.controllers;

import com.openlab.edition.domaine.editeur.EditeurProvider;
import com.openlab.edition.domaine.editeur.model.Editeur;
import com.openlab.edition.infras.adaptateurs.EditeurRepositoryAdaptateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/editeur")
public class EditeurController {
    private final EditeurRepositoryAdaptateur editeurRepositoryAdaptateur;

    public EditeurController(EditeurRepositoryAdaptateur editeurRepositoryAdaptateur) {
        this.editeurRepositoryAdaptateur = editeurRepositoryAdaptateur;
    }


    @PostMapping
    public ResponseEntity<Editeur> createEditeur(@RequestBody  Editeur editeur){
        Editeur saveEditeur = editeurRepositoryAdaptateur.save(editeur);
        return ResponseEntity.ok(saveEditeur);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editeur> getEditeurById(@PathVariable Long id){
        Optional<Editeur> editeur = editeurRepositoryAdaptateur.findById(id);
        return editeur.map(ResponseEntity::ok).orElseGet(()->
            ResponseEntity.notFound().build());
    }

}
