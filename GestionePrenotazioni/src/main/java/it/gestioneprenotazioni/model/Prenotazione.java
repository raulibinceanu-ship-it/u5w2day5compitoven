package it.gestioneprenotazioni.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Postazione postazione;

    public Prenotazione() {
    }
    public Prenotazione(LocalDate data, Utente utente, Postazione postazione) {
        this.data = data;
        this.utente = utente;
        this.postazione = postazione;
    }
    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Utente getUtente() {
        return utente;
    }

    public Postazione getPostazione() {
        return postazione;
    }
}
