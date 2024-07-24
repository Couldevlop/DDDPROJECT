package com.openlab.comptabilite.domaine.paiement;

import com.openlab.comptabilite.domaine.paiement.model.Paiement;

public interface PaiementProvider {
    Paiement register(Paiement paiement);

}
