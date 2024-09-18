package id.ac.ui.uibg.tournament.controller;

import id.ac.ui.uibg.tournament.dto.ImageModel;
import id.ac.ui.uibg.tournament.model.Image;
import id.ac.ui.uibg.tournament.model.Participant;
import id.ac.ui.uibg.tournament.model.Tournament;
import id.ac.ui.uibg.tournament.repository.ParticipantRepository;
import id.ac.ui.uibg.tournament.service.CloudinaryServiceImpl;
import id.ac.ui.uibg.tournament.service.TournamentService;
import id.ac.ui.uibg.tournament.service.ImageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/tournaments")
@RequiredArgsConstructor
@CrossOrigin
public class TournamentController {

    private final TournamentService tournamentService;
    private final ImageService imageService;
    private final ParticipantRepository participantRepository;
    private final CloudinaryServiceImpl cloudService;

    private final List<String> allowedContentTypes = List.of("image/jpeg", "image/png", "image/jpg", "image/webp");

    @PostMapping("/{tournamentId}/register/{userId}")
    public ResponseEntity<Participant> registerParticipant(
            @PathVariable UUID tournamentId,
            @PathVariable UUID userId,
            @Valid @RequestBody Participant participant,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        Participant registeredParticipant = tournamentService.registerParticipant(tournamentId, participant, userId);
        try {
            registeredParticipant.setImageName(cloudService.uploadFile(image,"folder_faculty_tour"));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(registeredParticipant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable UUID id) {
        return tournamentService.getTournamentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        return ResponseEntity.ok(tournaments);
    }
}
