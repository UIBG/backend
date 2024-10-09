package id.ac.ui.uibg.maintour.repository;

import id.ac.ui.uibg.maintour.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<University, UUID> {

}