package org.nic.bug_tracker_system.uploadFiles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileUploadController {

    private final String uploadDir = "C:/uploads/"; // 

    @PostMapping("api/upload")
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, String> response = new HashMap<>();

        // Check if the file is empty
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "File is empty"));
        }

        try {
            // Create the upload directory if it does not exist
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Define the file path to save the uploaded file
            String filePath = uploadDir + file.getOriginalFilename();
            Path path = Paths.get(filePath);
            
            // Save the file
            Files.copy(file.getInputStream(), path);
            
            // Construct the URL to access the uploaded file
            String fileDownloadUri = "http://localhost:9090/api/download/" + file.getOriginalFilename(); // Adjust the URL as needed

            // Add the file link to the response
            response.put("attachmentLink", fileDownloadUri);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "File upload failed: " + e.getMessage()));
        }
    }
}
