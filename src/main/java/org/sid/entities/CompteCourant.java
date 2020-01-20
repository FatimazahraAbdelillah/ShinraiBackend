package org.sid.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.apache.catalina.mbeans.ClassNameMBean;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.server.core.Relation;

import javax.xml.soap.Name;
import java.util.Collection;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@Builder
public class CompteCourant extends Compte{
    private double decouvert;

    public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, Collection<Operation> operations, double decouvert) {
        super(codeCompte, dateCreation, solde, client,operations);
        this.decouvert = decouvert;
    }

    public CompteCourant(double decouvert) {
        this.decouvert = decouvert;
    }

    public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, double decouvert) {
        super(codeCompte, dateCreation, solde, client);
        this.decouvert = decouvert;
    }
}
