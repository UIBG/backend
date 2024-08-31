package id.ac.ui.uibg.tournament.controller;

import id.ac.ui.uibg.tournament.model.Faculty;
import id.ac.ui.uibg.tournament.model.Major;
import id.ac.ui.uibg.tournament.service.FacultyMajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/faculty-major")
@RequiredArgsConstructor
@CrossOrigin
public class FacultyMajorController {
    private final FacultyMajorService facultyMajorService;
    @GetMapping("/faculties")
    public ResponseEntity<List<Faculty>> getAllFaculty() {
        List<Faculty> faculties = facultyMajorService.getAllFaculty();
        return ResponseEntity.ok(faculties);
    }
    @GetMapping("/majors")
    public ResponseEntity<List<Major>> getAllMajor() {
        List<Major> majors = facultyMajorService.getALlMajor();
        return ResponseEntity.ok(majors);
    }
    @GetMapping("/majors/{facultyId}")
    public ResponseEntity<List<Major>> getMajorByFacultyId(@PathVariable UUID facultyId) {
        List<Major> majors = facultyMajorService.getMajorByFacultyId(facultyId);
        return ResponseEntity.ok(majors);
    }
    @GetMapping("/major/{majorId}")
    public ResponseEntity<Major> getMajorById(@PathVariable UUID majorId) {
        return facultyMajorService.getMajorById(majorId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable UUID facultyId) {
        return facultyMajorService.getFacultyById(facultyId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
