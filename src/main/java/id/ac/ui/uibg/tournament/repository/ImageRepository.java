package id.ac.ui.uibg.tournament.repository;

import id.ac.ui.uibg.tournament.model.Image;
import jakarta.transaction.Transactional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<Image, UUID> {
    @Cacheable("images")
    Optional<Image> findByName(String fileName);

    void deleteByName(String fileName);
}
