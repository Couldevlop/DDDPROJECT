package com.openlab.comptabilite.domaine.cours;

import com.openlab.comptabilite.domaine.cours.model.Cours;

public interface CoursProvider {
    double getNbr();
    Cours register(Cours cours);
    Cours update(long idCours);
}
