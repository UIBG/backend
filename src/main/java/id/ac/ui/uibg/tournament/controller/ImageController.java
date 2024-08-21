package id.ac.ui.uibg.tournament.controller;

import id.ac.ui.uibg.tournament.model.Image;
import id.ac.ui.uibg.tournament.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@RequestMapping("/image")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class ImageController {
    @Autowired
    private ImageService imageService;
    @PostMapping("")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile image) throws IOException {
        Image uploadImage = imageService.uploadImageToFileSystem(image);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) throws IOException {
        byte[] downloadImage = imageService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(downloadImage);
    }
}

