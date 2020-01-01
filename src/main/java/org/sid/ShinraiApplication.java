package org.sid;

import org.sid.dao.*;
import org.sid.entities.*;
import org.sid.metier.IBanqueMetier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ShinraiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShinraiApplication.class, args);
    }
    @Bean
    CommandLineRunner start (ClientRepository clientRepository, CompteRepository compteRepository,
                             OperationRepository operationRepository, IBanqueMetier banqueMetier) {
        return args->{
            clientRepository.deleteAll();
            compteRepository.deleteAll();
            operationRepository.deleteAll();
         Client c1=  clientRepository.save(new Client("fati","fatimazahra.abdelillah@gmail.com"));
            Client c2=  clientRepository.save(new Client("khadija","fatimazahra.abdelillah@gmail.com"));
            Compte cp1= compteRepository.save(new CompteCourant("c1" ,new Date(), 8000, c1, 5.66));
            Compte cp2= compteRepository.save(new CompteCourant("c2" ,new Date(), 9000, c2, 9000));
            operationRepository.save(new Versement(new Date(), 9000, cp1));
            operationRepository.save(new Versement(new Date(), 6000, cp1));
            operationRepository.save(new Versement(new Date(), 2300, cp1));
            operationRepository.save(new Retrait(new Date(), 7000, cp2));
            operationRepository.save(new Retrait(new Date(), 500, cp2));
            operationRepository.save(new Retrait(new Date(), 2300, cp2));
            banqueMetier.verser("c2",100);

        };
    }
}
