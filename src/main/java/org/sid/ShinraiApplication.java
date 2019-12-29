package org.sid;

import org.sid.dao.*;
import org.sid.entities.*;
import org.sid.metier.IBanqueMetier;
import org.sid.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class ShinraiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShinraiApplication.class, args);
    }
    @Bean
    CommandLineRunner start (ClientRepository clientRepository, CompteRepository compteRepository,
                             OperationRepository operationRepository, IBanqueMetier banqueMetier,
                             AppUserRepository appUserRepository,AppRoleRepository appRoleRepository,AccountService accountService) {
        return args->{
            appUserRepository.deleteAll();
            appRoleRepository.deleteAll();
            accountService.save(new AppRole(null,"USER"));
            accountService.save(new AppRole(null,"ADMIN"));
            Stream.of("user1","user2","user3","admin").forEach( ac  ->{
                accountService.saveUser(ac,"fatimazahra.abdelillah@gmail.com","1234","1234");
            });
            accountService.addRoleToUser("admin","ADMIN");
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
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
}
