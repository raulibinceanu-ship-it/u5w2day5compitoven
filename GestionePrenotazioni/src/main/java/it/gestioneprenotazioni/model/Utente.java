package it.gestioneprenotazioni.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity

public class Utente {
        @Id
        private String username;

        private String nomeCompleto;
        private String email;
    public Utente() {
    }
    public Utente(String username, String nomeCompleto, String email) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }
    public String getUsername() {
        return username;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }
    }
