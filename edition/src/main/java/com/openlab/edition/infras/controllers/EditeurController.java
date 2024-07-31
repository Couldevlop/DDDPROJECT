package com.openlab.edition.infras.controllers;

import com.openlab.edition.domaine.editeur.EditeurProvider;
import com.openlab.edition.domaine.editeur.model.Editeur;
import com.openlab.edition.infras.adaptateurs.EditeurRepositoryAdaptateur;
import com.openlab.edition.infras.dtos.EditeurDTO;
import com.openlab.edition.infras.mapper.Mapper;
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
    public ResponseEntity<EditeurDTO> createEditeur(@RequestBody  Editeur editeur){
        Editeur saveEditeur = editeurRepositoryAdaptateur.save(editeur);
        return ResponseEntity.ok(Mapper.toDTO(saveEditeur) );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditeurDTO> getEditeurById(@PathVariable Long id){
        Optional<Editeur> editeur = editeurRepositoryAdaptateur.findById(id);
        return  editeur.map(value -> ResponseEntity.ok(Mapper.toDTO(value))).orElseGet(()->
            ResponseEntity.notFound().build());
    }

}
