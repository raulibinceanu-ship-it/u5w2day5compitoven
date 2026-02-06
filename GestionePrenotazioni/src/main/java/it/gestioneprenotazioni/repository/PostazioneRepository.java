package it.gestioneprenotazioni.repository;

import it.gestioneprenotazioni.model.Postazione;
import it.gestioneprenotazioni.model.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}