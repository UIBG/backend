package id.ac.ui.uibg.tournament.service;

import id.ac.ui.uibg.tournament.dto.ImageModel;
import id.ac.ui.uibg.tournament.model.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageService {
    public ResponseEntity<Map> uploadImage(ImageModel imageModel);

}
