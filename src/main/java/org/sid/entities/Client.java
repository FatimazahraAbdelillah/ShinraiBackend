package org.sid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Document
@Data
public class Client implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;
    private Collection<Compte> compte;

    public Client(String name, String email) {
        this.name= name;
        this.email = email;
    }
}
