package id.ac.ui.uibg.maintour.repository;

import id.ac.ui.uibg.maintour.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {

}