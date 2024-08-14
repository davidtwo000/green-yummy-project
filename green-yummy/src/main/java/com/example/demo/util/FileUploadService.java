package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {

    @Value("${media.filepath}")
    private String uploadDir;

    @Value("${admin.media.filepath}")
    private String adminUploadDir;
    
	public String saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Cannot store empty file.");
        }

        // 파일 이름 생성
        String filename = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        Path path = Paths.get(uploadDir + "/" + filename);
        // 파일 저장
        Files.copy(file.getInputStream(), path);
        
        Path adminPath = Paths.get(adminUploadDir + "/" + filename);
        Files.copy(file.getInputStream(), adminPath, StandardCopyOption.REPLACE_EXISTING);

        
        return filename;
    }
    
}