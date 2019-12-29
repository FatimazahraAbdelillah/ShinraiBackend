package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
public abstract class Operation implements Serializable {
    @Id
    private String numero;
    private Date dateOperation;
    private double montant;
    private Compte compte;

    public Operation( Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }
}
