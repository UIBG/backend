package id.ac.ui.uibg.tournament.repository;

import id.ac.ui.uibg.tournament.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacultyRepository extends JpaRepository<Faculty, UUID> {
}
