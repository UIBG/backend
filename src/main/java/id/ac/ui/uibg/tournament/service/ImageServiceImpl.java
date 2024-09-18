package id.ac.ui.uibg.tournament.service;

import id.ac.ui.uibg.tournament.dto.ImageModel;
import id.ac.ui.uibg.tournament.model.Image;
import id.ac.ui.uibg.tournament.repository.ImageRepository;
import id.ac.ui.uibg.tournament.service.CloudinaryService;
import id.ac.ui.uibg.tournament.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public ResponseEntity<Map> uploadImage(ImageModel imageModel) {
        try {
            if (imageModel.getName().equals("")) {
                return ResponseEntity.badRequest().build();
            }
            if (imageModel.getFile().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            Image image = new Image();
            image.setName(imageModel.getName());
            image.setUrl(cloudinaryService.uploadFile(imageModel.getFile(), "folder_1"));
            if(image.getUrl() == null) {
                return ResponseEntity.badRequest().build();
            }
            imageRepository.save(image);
            return ResponseEntity.ok().body(Map.of("url", image.getUrl()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
