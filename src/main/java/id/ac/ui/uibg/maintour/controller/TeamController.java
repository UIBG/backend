package id.ac.ui.uibg.maintour.controller;

import id.ac.ui.uibg.maintour.model.*;
import id.ac.ui.uibg.maintour.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        Team newTeam = teamService.createTeam(team);
        return ResponseEntity.ok(newTeam);
    }

    @PostMapping("/{teamId}/addPubgPlayer")
    public ResponseEntity<Team> addPubgPlayer(@PathVariable UUID teamId, @RequestBody PubgPlayer pubgPlayer) {
        Team updatedTeam = teamService.addPubgPlayerToTeam(teamId, pubgPlayer);
        return ResponseEntity.ok(updatedTeam);
    }

    @PostMapping("/{teamId}/addValorantPlayer")
    public ResponseEntity<Team> addValorantPlayer(@PathVariable UUID teamId, @RequestBody ValorantPlayer valorantPlayer) {
        Team updatedTeam = teamService.addValorantPlayerToTeam(teamId, valorantPlayer);
        return ResponseEntity.ok(updatedTeam);
    }

    @PostMapping("/{teamId}/addMobileLegendsPlayer")
    public ResponseEntity<Team> addMobileLegendsPlayer(@PathVariable UUID teamId, @RequestBody MLPlayer mlPlayer) {
        Team updatedTeam = teamService.addMLPlayerToTeam(teamId, mlPlayer);
        return ResponseEntity.ok(updatedTeam);
    }

    @PostMapping("/{teamId}/addLokapalaPlayer")
    public ResponseEntity<Team> addLokapalaPlayer(@PathVariable UUID teamId, @RequestBody LokapalaPlayer lokapalaPlayer) {
        Team updatedTeam = teamService.addLokapalaPlayerToTeam(teamId, lokapalaPlayer);
        return ResponseEntity.ok(updatedTeam);
    }
}
