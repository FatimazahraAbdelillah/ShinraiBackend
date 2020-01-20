package org.sid.metier;

import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface IBanqueMetier {
    public Compte consulterCompte (String codeCompte);
    public void verser(String codeCompte,double montant);
    public void retirer(String codeCompte,double montant);
    public void virement(String codeCpte1, String codeCpte2, double montant);
}
