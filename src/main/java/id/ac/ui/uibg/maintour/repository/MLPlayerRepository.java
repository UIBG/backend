package id.ac.ui.uibg.maintour.repository;

import id.ac.ui.uibg.maintour.model.MLPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MLPlayerRepository extends JpaRepository<MLPlayer, UUID> {

}
