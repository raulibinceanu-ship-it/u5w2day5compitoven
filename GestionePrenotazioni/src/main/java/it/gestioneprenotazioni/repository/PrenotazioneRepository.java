package it.gestioneprenotazioni.repository;

import it.gestioneprenotazioni.model.Prenotazione;
import it.gestioneprenotazioni.model.Postazione;
import it.gestioneprenotazioni.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
}
