package com.example.demo.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploader {

    @Autowired
    private FilePathBuilder builder;

    private Logger logger = Logger.getLogger(getClass().getName());

    public String uploadFileAndGetChangedFileName(MultipartFile file, String folder) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }

        String originalFileName = file.getOriginalFilename();
        if (originalFileName == null) {
            throw new IOException("File name is null");
        }

        // Get the file extension
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));

        // Get current date and time formatted as yyyyMMdd_HHmmss
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = now.format(formatter);

        // Create new file name with the format: yyyyMMdd_HHmmss_originalFileName
        String newFileName = formattedDateTime + "_" + originalFileName;

        // Build the destination path
        String dest = builder.buildFilePath(newFileName, folder);
        Path path = Paths.get(dest);
        Path parent = path.getParent();

        // Create directories if they do not exist
        if (!Files.exists(parent)) {
            logger.info("Creating directories: " + parent);
            Files.createDirectories(parent);
        }

        // Save the file to the path
        logger.info("Saving file to: " + path);
        Files.write(path, file.getBytes());

        // Return the new file name
        return newFileName;
    }
}