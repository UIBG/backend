package id.ac.ui.uibg.tournament.repository;

import id.ac.ui.uibg.auth.model.User;
import id.ac.ui.uibg.tournament.model.Participant;
import id.ac.ui.uibg.tournament.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {
    int countByTournamentId(UUID tournamentId);
    Optional<Participant> findByUserAndTournament(User user, Tournament tournament);
}
