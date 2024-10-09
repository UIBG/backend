package id.ac.ui.uibg.maintour.controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;

import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStreamReader;
import java.util.Collections;

@RestController()
@RequestMapping("/api/drive")
public class GoogleDriveController {

    private static final String APPLICATION_NAME = "UIBG";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private Drive driveService;
    @GetMapping("/test")
    public void test(HttpServletResponse response) throws Exception {
        response.getWriter().write("Test successful");
    }
    @GetMapping("/authorize")
    public void authorize(HttpServletResponse response) throws Exception {
        // Load client secrets
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                new InputStreamReader(getClass().getResourceAsStream("/credentials.json")));

        // Build flow and trigger user authorization request
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, clientSecrets,
                Collections.singleton(DriveScopes.DRIVE_FILE))
                .setAccessType("offline")
                .build();

        String redirectUri = "http://localhost:8080/oauth2callback";
        String authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectUri).build();

        // Send redirect to the authorization URL
        response.sendRedirect(authorizationUrl);
    }

    public String oauth2callback(HttpServletRequest request) throws Exception {
        // Get the authorization code from the request
        String code = request.getParameter("code");

        if (code == null) {
            return "Authorization code not found.";
        }

        // Load client secrets
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                new InputStreamReader(getClass().getResourceAsStream("/credentials.json")));

        // Build flow and exchange the authorization code for an access token
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, clientSecrets,
                Collections.singleton(DriveScopes.DRIVE_FILE))
                .setAccessType("offline")
                .build();

        // Exchange the code for a token
        GoogleTokenResponse tokenResponse = flow.newTokenRequest(code)
                .setRedirectUri("http://localhost:8080/oauth2callback")
                .execute();

        // Create a Credential object
        Credential credential = flow.createAndStoreCredential(tokenResponse, "user");

        // Initialize Drive service
        driveService = new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        return "Authorization successful! You can now upload images.";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // Create a temporary file
            java.io.File tempFile = java.io.File.createTempFile("upload-", file.getOriginalFilename());
            file.transferTo(tempFile); // Transfer the contents of the MultipartFile to the temporary file
            // Prepare the file for upload
            File googleFile = new File();
            googleFile.setName(file.getOriginalFilename());
            googleFile.setMimeType(file.getContentType());

            // Create FileContent object
            FileContent mediaContent = new FileContent(file.getContentType(), tempFile);

            // Upload the file to Google Drive
            File uploadedFile = driveService.files().create(googleFile, mediaContent)
                    .setFields("id")
                    .execute();

            return ResponseEntity.ok("File uploaded successfully! File ID: " + uploadedFile.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed: " + e.getMessage());
        }
    }


}

