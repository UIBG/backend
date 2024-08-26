package id.ac.ui.uibg.tournament.service;

import id.ac.ui.uibg.auth.model.User;
import id.ac.ui.uibg.auth.repository.UserRepository;
import id.ac.ui.uibg.tournament.model.Participant;
import id.ac.ui.uibg.tournament.model.Tournament;
import id.ac.ui.uibg.tournament.repository.ParticipantRepository;
import id.ac.ui.uibg.tournament.repository.TournamentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final ParticipantRepository participantRepository;
    private final UserRepository userRepository;

    @Transactional
    public Participant registerParticipant(UUID tournamentId, Participant participant, UUID userId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the user is already registered for the tournament
        Optional<Participant> existingParticipant = participantRepository
                .findByUserAndTournament(user, tournament);

        if (existingParticipant.isPresent()) {
            throw new RuntimeException("User is already registered for this tournament");
        }
        participant.setUser(user);
        participant.setTournament(tournament);
        tournament.getParticipantList().add(participant);
        tournamentRepository.save(tournament);
        return participantRepository.save(participant);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(UUID id) {
        return tournamentRepository.findById(id);
    }
}
