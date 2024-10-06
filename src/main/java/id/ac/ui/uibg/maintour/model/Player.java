package id.ac.ui.uibg.maintour.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Data
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID playerId;

    private String teamName;

    private String playerName;

    private String studentCardImg;

    private String studentImg;

    private String faculty; // ??

    private String batch; // ??

    private String studentCardNumber; // ??

    private String email;

    private String waNumber;

    private String lineId;

    private String profileAccSS;

    private String game; // ??

}
