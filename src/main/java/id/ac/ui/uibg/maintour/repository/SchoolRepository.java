package id.ac.ui.uibg.maintour.repository;

import id.ac.ui.uibg.maintour.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SchoolRepository extends JpaRepository<School, UUID> {

}