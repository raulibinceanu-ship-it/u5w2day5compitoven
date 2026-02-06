package it.gestioneprenotazioni.repository;

import it.gestioneprenotazioni.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {
}
