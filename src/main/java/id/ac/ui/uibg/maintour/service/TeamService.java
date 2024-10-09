package id.ac.ui.uibg.maintour.service;

import id.ac.ui.uibg.maintour.model.*;
import id.ac.ui.uibg.maintour.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team addPubgPlayerToTeam(UUID teamId, PubgPlayer pubgPlayer) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        team.addPlayer(pubgPlayer);
        return teamRepository.save(team);
    }

    public Team addValorantPlayerToTeam(UUID teamId, ValorantPlayer valorantPlayer) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        team.addPlayer(valorantPlayer);
        return teamRepository.save(team);
    }

    public Team addMLPlayerToTeam(UUID teamId, MLPlayer mlPlayer) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        team.addPlayer(mlPlayer);
        return teamRepository.save(team);
    }

    public Team addLokapalaPlayerToTeam(UUID teamId, LokapalaPlayer lokapalaPlayer) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Team not found"));
        team.addPlayer(lokapalaPlayer);
        return teamRepository.save(team);
    }


}
