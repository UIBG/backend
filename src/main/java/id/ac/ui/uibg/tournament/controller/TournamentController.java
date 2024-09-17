package id.ac.ui.uibg.tournament.controller;

import id.ac.ui.uibg.tournament.model.Image;
import id.ac.ui.uibg.tournament.model.Participant;
import id.ac.ui.uibg.tournament.model.Tournament;
import id.ac.ui.uibg.tournament.repository.ParticipantRepository;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/tournaments")
@RequiredArgsConstructor
@CrossOrigin
public class TournamentController {

    private final TournamentService tournamentService;
    private final ImageService imageService;
    private final ParticipantRepository participantRepository;

    private final List<String> allowedContentTypes = List.of("image/jpeg", "image/png", "image/jpg", "image/webp");

    @PostMapping("/{tournamentId}/register/{userId}")
    public ResponseEntity<Participant> registerParticipant(
            @PathVariable UUID tournamentId,
            @PathVariable UUID userId,
            @Valid @RequestBody Participant participant,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        // Validate if the uploaded file is an image
        if (!allowedContentTypes.contains(image.getContentType())) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                    .body(null); // You can send a custom error message here
        }

        Image image1 = imageService.uploadImageToFileSystem(image);
        Participant registeredParticipant = tournamentService.registerParticipant(tournamentId, participant, userId);
        registeredParticipant.setImageName(image1.getName());

        return ResponseEntity.ok(registeredParticipant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable UUID id) {
        return tournamentService.getTournamentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
