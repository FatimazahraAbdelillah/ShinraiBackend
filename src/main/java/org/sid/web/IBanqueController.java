package org.sid.web;

import org.sid.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/saveoperation")
public class IBanqueController {
    @Autowired
    private IBanqueMetier iBanqueMetier;
    @RequestMapping(value = "/virement/{codeCompte}/{codeCpte2}/{montant}",method = RequestMethod.POST)
    public void virement(@PathVariable String codeCompte, @PathVariable String codeCpte2, @PathVariable  double montant) {
       iBanqueMetier.retirer(codeCompte,montant);
        iBanqueMetier.verser(codeCpte2,montant);
    }
    @RequestMapping(value = "/versement/{codeCompte}/{montant}",method = RequestMethod.POST)
    public void versement(@PathVariable String codeCompte, @PathVariable  double montant) {
        iBanqueMetier.verser(codeCompte,montant);
    }
    @RequestMapping(value = "/retrait/{codeCompte}/{montant}",method = RequestMethod.POST)
    public void retrait(@PathVariable String codeCompte, @PathVariable  double montant) {
        iBanqueMetier.retirer(codeCompte,montant);
    }
}
