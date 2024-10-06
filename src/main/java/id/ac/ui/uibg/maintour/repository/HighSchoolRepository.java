package id.ac.ui.uibg.maintour.repository;

import id.ac.ui.uibg.maintour.model.HighSchool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HighSchoolRepository extends JpaRepository<HighSchool, UUID> {

}
