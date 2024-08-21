package id.ac.ui.uibg.tournament.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Major {
    @Id
    private UUID majorId;
    private UUID facultyId;
    private String majorName;
}
