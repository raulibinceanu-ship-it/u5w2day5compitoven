package it.gestioneprenotazioni.model;
import jakarta.persistence.*;
@Entity
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codice;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private int maxOccupanti;

    @ManyToOne
    private Edificio edificio;
    public Postazione() {
    }
    public Postazione(String codice, String descrizione, TipoPostazione tipo, int maxOccupanti, Edificio edificio) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.maxOccupanti = maxOccupanti;
        this.edificio = edificio;
    }

    public Long getId() {
        return id;
    }

    public String getCodice() {
        return codice;
    }

    public TipoPostazione getTipo() {
        return tipo;
    }

    public Edificio getEdificio() {
        return edificio;
    }
}
