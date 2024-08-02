package com.openlab.edition.infras.controllers;

import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.infras.adaptateurs.AuteurRepositoryAdaptateur;
import com.openlab.edition.infras.dtos.AuteurDTO;
import com.openlab.edition.infras.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auteur")
public class AuteurController {
    private final AuteurRepositoryAdaptateur auteurRepositoryAdaptateur;

    public AuteurController(AuteurRepositoryAdaptateur auteurRepositoryAdaptateur) {
        this.auteurRepositoryAdaptateur = auteurRepositoryAdaptateur;
    }

    @PostMapping
    public ResponseEntity<AuteurDTO> createAuteur(@RequestBody  AuteurDTO auteurDTO){
        Auteur auteur = Mapper.toDomain(auteurDTO);
        Auteur auteurSaved = auteurRepositoryAdaptateur.save(auteur);
       return new ResponseEntity<>(Mapper.toDTO(auteurSaved)  , HttpStatus.OK);

    }
}
