package it.gestioneprenotazioni.runner;

import it.gestioneprenotazioni.model.*;
import it.gestioneprenotazioni.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AppRunner implements CommandLineRunner {

    private final EdificioRepository edificioRepository;
    private final PostazioneRepository postazioneRepository;
    private final UtenteRepository utenteRepository;
    private final PrenotazioneRepository prenotazioneRepository;

    public AppRunner(EdificioRepository edificioRepository,
                     PostazioneRepository postazioneRepository,
                     UtenteRepository utenteRepository,
                     PrenotazioneRepository prenotazioneRepository) {
        this.edificioRepository = edificioRepository;
        this.postazioneRepository = postazioneRepository;
        this.utenteRepository = utenteRepository;
        this.prenotazioneRepository = prenotazioneRepository;
    }

    @Override
    public void run(String... args) {
        // === CREAZIONE DATI ===
        Edificio edificio = new Edificio(
                "Sede Centrale",
                "Via Roma 1",
                "Milano"
        );
        edificioRepository.save(edificio);

        Postazione postazione = new Postazione(
                "P1",
                "Postazione privata",
                TipoPostazione.PRIVATO,
                1,
                edificio
        );
        postazioneRepository.save(postazione);

        Utente utente = new Utente(
                "mrossi",
                "Mario Rossi",
                "mario.rossi@email.it"
        );
        utenteRepository.save(utente);

        // === PRENOTAZIONE ===
        LocalDate data = LocalDate.now();

        List<Prenotazione> prenPostazione =
                prenotazioneRepository.findByPostazioneAndData(postazione, data);

        List<Prenotazione> prenUtente =
                prenotazioneRepository.findByUtenteAndData(utente, data);

        if (prenPostazione.isEmpty() && prenUtente.isEmpty()) {

            Prenotazione prenotazione = new Prenotazione(data, utente, postazione);
            prenotazioneRepository.save(prenotazione);

            System.out.println("Prenotazione effettuata con successo!");

        } else {
            System.out.println("Prenotazione NON possibile.");
        }
// === RICERCA POSTAZIONI ===
        System.out.println("\nPostazioni PRIVATO a Milano:");

        List<Postazione> risultati =
                postazioneRepository.findByTipoAndEdificio_Citta(
                        TipoPostazione.PRIVATO,
                        "Milano"
                );

        for (Postazione p : risultati) {
            System.out.println(p.getCodice());
        }
    }


    }