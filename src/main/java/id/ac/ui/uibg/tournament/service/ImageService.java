package id.ac.ui.uibg.tournament.service;

import id.ac.ui.uibg.tournament.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    public byte[] downloadImageFromFileSystem(String fileName) throws IOException;

    public void deleteImage(String fileName);

    public Image uploadImageToFileSystem(MultipartFile file) throws IOException;

}
