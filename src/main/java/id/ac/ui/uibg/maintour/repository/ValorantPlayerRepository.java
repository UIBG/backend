package id.ac.ui.uibg.maintour.repository;

import id.ac.ui.uibg.maintour.model.ValorantPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ValorantPlayerRepository extends JpaRepository<ValorantPlayer, UUID> {

}