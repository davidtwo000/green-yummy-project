package com.example.demo.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Component
public class OCRService {

    public String extractTextFromImage(String imagePath) {
        try {
            BufferedImage image = preprocessImage(imagePath);
            ITesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata"); // tessdata 경로 설정
            tesseract.setLanguage("eng+kor"); // 한국어와 영어 지원
            return tesseract.doOCR(image);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "OCR 실패: " + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "이미지 처리 실패: " + e.getMessage();
        }
    }

    private BufferedImage preprocessImage(String imagePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(imagePath));

        // 리사이징
        int baseWidth = 1200;
        int width = image.getWidth();
        int height = image.getHeight();
        int newHeight = (int) (height * ((double) baseWidth / width));
        Image scaledImage = image.getScaledInstance(baseWidth, newHeight, Image.SCALE_SMOOTH);

        BufferedImage resizedImage = new BufferedImage(baseWidth, newHeight, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        // 대비 조정
        RescaleOp rescaleOp = new RescaleOp(1.5f, 0, null);
        BufferedImage contrastedImage = rescaleOp.filter(resizedImage, null);

        // 샤프닝
        Kernel kernel = new Kernel(3, 3, new float[]{
            0, -0.25f, 0,
            -0.25f, 1.5f, -0.25f,
            0, -0.25f, 0
        });
        ConvolveOp convolveOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage sharpenedImage = convolveOp.filter(contrastedImage, null);

        // 임계값 변환
        BufferedImage binaryImage = new BufferedImage(sharpenedImage.getWidth(), sharpenedImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        for (int y = 0; y < sharpenedImage.getHeight(); y++) {
            for (int x = 0; x < sharpenedImage.getWidth(); x++) {
                int rgb = sharpenedImage.getRGB(x, y);
                int gray = (rgb >> 16) & 0xFF;
                binaryImage.setRGB(x, y, gray < 140 ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }

        return binaryImage;
    }
}