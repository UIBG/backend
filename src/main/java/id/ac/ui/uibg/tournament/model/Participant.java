package id.ac.ui.uibg.tournament.model;

import id.ac.ui.uibg.auth.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Setter
@Getter
public class Participant {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String faculty;
    private String major;
    private int batch;
    private String phoneNumber;
    private String imageName;
    private String TournamentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
}
