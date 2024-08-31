package id.ac.ui.uibg.tournament.service;

import id.ac.ui.uibg.tournament.model.Faculty;
import id.ac.ui.uibg.tournament.model.Major;
import id.ac.ui.uibg.tournament.repository.FacultyRepository;
import id.ac.ui.uibg.tournament.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FacultyMajorService {
    private final FacultyRepository facultyRepository;
    private final MajorRepository majorRepository;

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public List<Major> getALlMajor() {
        return majorRepository.findAll();
    }
    public List<Major> getMajorByFacultyId(UUID facultyId) {
        return majorRepository.findByFacultyId(facultyId);
    }

    public Optional<Faculty> getFacultyById(UUID facultyId) {
        return facultyRepository.findById(facultyId);
    }

    public Optional<Major> getMajorById(UUID majorId) {
        return majorRepository.findById(majorId);
    }
}
