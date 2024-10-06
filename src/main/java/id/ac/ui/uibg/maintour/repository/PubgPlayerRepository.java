package id.ac.ui.uibg.maintour.repository;

import id.ac.ui.uibg.maintour.model.PubgPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PubgPlayerRepository extends JpaRepository<PubgPlayer, UUID> {

}
