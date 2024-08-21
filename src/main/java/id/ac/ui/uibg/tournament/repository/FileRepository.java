package id.ac.ui.uibg.tournament.repository;

import id.ac.ui.uibg.tournament.model.File;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface FileRepository extends JpaRepository<File, UUID> {
    Optional<File> findByName(String name);
}

