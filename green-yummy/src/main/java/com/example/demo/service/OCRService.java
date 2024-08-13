package com.example.demo.service;

import java.io.File;

import org.springframework.stereotype.Component;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Component
public class OCRService {

    public String extractTextFromImage(String imagePath) {
        Tesseract tesseract = new Tesseract();	
        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata"); // tessdata 경로 설정
        tesseract.setLanguage("kor"); // 한국어 지원이 필요할 경우 언어 설정

        try {
            return tesseract.doOCR(new File(imagePath));
        } catch (TesseractException e) {
            e.printStackTrace();
            return "OCR 실패: " + e.getMessage();
        }
    }
}