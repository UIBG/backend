package id.ac.ui.uibg.tournament.repository;

import id.ac.ui.uibg.tournament.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MajorRepository extends JpaRepository<Major, UUID> {
    public List<Major> findByFacultyId(UUID facultyID);
}
