package com.openlab.comptabilite.domaine.paiement;

import com.openlab.comptabilite.domaine.paiement.model.PaiementEvent;

public interface PaiementNotificationProvider {
    void notify(PaiementEvent paiementEvent);
}
