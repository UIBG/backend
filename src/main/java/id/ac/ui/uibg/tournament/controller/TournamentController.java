package id.ac.ui.uibg.tournament.controller;

import id.ac.ui.uibg.tournament.model.Participant;
import id.ac.ui.uibg.tournament.model.Tournament;
import id.ac.ui.uibg.tournament.service.TournamentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tournaments")
@RequiredArgsConstructor
public class TournamentController {

    private final TournamentService tournamentService;

    @PostMapping("/{tournamentId}/register/{userId}")
    public ResponseEntity<Participant> registerParticipant(
            @PathVariable UUID tournamentId,
            @PathVariable UUID userId,
            @Valid @RequestBody Participant participant
    ) {
        Participant registeredParticipant = tournamentService.registerParticipant(tournamentId, participant, userId);
        return ResponseEntity.ok(registeredParticipant);
    }

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        Tournament createdTournament = tournamentService.createTournament(tournament);
        return ResponseEntity.ok(createdTournament);
    }

    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        return ResponseEntity.ok(tournaments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable UUID id) {
        return tournamentService.getTournamentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournament(
            @PathVariable UUID id,
            @RequestBody Tournament tournamentDetails
    ) {
        Tournament updatedTournament = tournamentService.updateTournament(id, tournamentDetails);
        return ResponseEntity.ok(updatedTournament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable UUID id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.noContent().build();
    }
}
