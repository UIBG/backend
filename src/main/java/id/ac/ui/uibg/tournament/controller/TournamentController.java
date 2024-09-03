package id.ac.ui.uibg.tournament.controller;

import id.ac.ui.uibg.tournament.model.Image;
import id.ac.ui.uibg.tournament.model.Participant;
import id.ac.ui.uibg.tournament.model.Tournament;
import id.ac.ui.uibg.tournament.repository.ParticipantRepository;
import id.ac.ui.uibg.tournament.service.TournamentService;
import id.ac.ui.uibg.tournament.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tournaments")
@RequiredArgsConstructor
public class TournamentController {

    private final TournamentService tournamentService;
    private final ImageService imageService;
    private final ParticipantRepository participantRepository;

    @PostMapping("/{tournamentId}/register/{userId}")
    public ResponseEntity<Participant> registerParticipant(
            @PathVariable UUID tournamentId,
            @PathVariable UUID userId,
            @Valid @RequestPart("participant") Participant participant,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        Image image1 = imageService.uploadImageToFileSystem(image);
        Participant registeredParticipant = tournamentService.registerParticipant(tournamentId, participant, userId);
        registeredParticipant.setImageName(image1.getName());
        participantRepository.save(registeredParticipant);
        return ResponseEntity.ok(registeredParticipant);
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
}
