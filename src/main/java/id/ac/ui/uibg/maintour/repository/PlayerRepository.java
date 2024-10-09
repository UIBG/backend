package id.ac.ui.uibg.maintour.repository;

import id.ac.ui.uibg.maintour.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

}
