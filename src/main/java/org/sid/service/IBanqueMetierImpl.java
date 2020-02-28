package org.sid.service;

import org.sid.dao.CompteRepository;
import org.sid.dao.OperationRepository;
import org.sid.entities.*;
import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.*;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
@Service
@Transactional
public class IBanqueMetierImpl implements IBanqueMetier {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte cp = compteRepository.findById(codeCompte).get();
        if(cp==null) throw new RuntimeException("Compte introuvable");
        return cp;
    }

    @Override
    public void verser(String codeCompte, double montant) {
        Compte cp = consulterCompte(codeCompte);
        Versement v =new Versement(new Date(),montant,cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);
    }

    @Override
    public void retirer(String codeCompte, double montant) {
        Compte cp = consulterCompte(codeCompte);
        double facilitiesCaisse=0;
        if (cp instanceof CompteCourant)
        facilitiesCaisse=((CompteCourant) cp).getDecouvert();
        if(cp.getSolde()+facilitiesCaisse<montant) throw new RuntimeException("Solde insuffisant");
        Retrait r =new Retrait(new Date(),montant,cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);

    }

    @Override
    public void virement(String codeCpte1, String codeCpte2, double montant) {
        retirer(codeCpte1,montant);
        verser(codeCpte2,montant);
    }

}
