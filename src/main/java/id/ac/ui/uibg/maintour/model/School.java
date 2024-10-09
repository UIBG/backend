package id.ac.ui.uibg.maintour.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Data
@Setter
@Getter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID schoolId;

    private String schoolName;
}
