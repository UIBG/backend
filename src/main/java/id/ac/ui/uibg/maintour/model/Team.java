package id.ac.ui.uibg.maintour.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Data
@Setter
@Getter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID teamId;

    private String teamName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private School schoolOrigin;

    private String hsOrUni;

    private String teamLogoLink;

    private String captainName;

    private String captainWaNumber;

    private int playerTotal;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "team_id")
    private ArrayList<Player> players;

    private String game; // ??

    private String gameName;
}
