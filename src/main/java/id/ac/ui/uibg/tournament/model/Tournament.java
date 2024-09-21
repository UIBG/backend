package id.ac.ui.uibg.tournament.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Data
public class Tournament {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String name;


}
