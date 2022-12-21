package com.example.imageinfo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
    @Value("${file.image.book}") String bookImgPath;
    @Value("${file.image.description}") String bookDescImgPath;

    public Map<String, Object> uploadFiles(String type, List<MultipartFile> files) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Path baseDir = null;
        if(type.equals("book")) {
            baseDir = Paths.get(bookImgPath);
        }
        else if(type.equals("desc")) {
            baseDir = Paths.get(bookDescImgPath);
        }
        else {
            resultMap.put("status", false);
            resultMap.put("message", "invalid type of ("+type+") [e.g. valid types:book,desc]");
            resultMap.put("code", HttpStatus.BAD_REQUEST);
            return resultMap;
        }
        List<String> savedFileList = new ArrayList<String>();

        for(MultipartFile file : files) {
            String originFileName = file.getOriginalFilename();
            String[] split = originFileName.split("\\.");
            String ext = split[split.length-1];
            String saveFileName = generateRandomFileName();

            Calendar c = Calendar.getInstance();
            saveFileName += c.getTimeInMillis()+"."+ext;
            Path target = baseDir.resolve(saveFileName);
            try {
                Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
                savedFileList.add(saveFileName);
            }
            catch(Exception e) {
                resultMap.put("status", false);
                resultMap.put("message", "File transfer failed");
                resultMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
                return resultMap;
            }
            resultMap.put("status", true);
            resultMap.put("message", "File transfer succeeded");
            resultMap.put("filelist", savedFileList);
            resultMap.put("code", HttpStatus.CREATED);
        }
        return resultMap;
    }

    public static String generateRandomFileName() {
        String str = "";
        for (int i = 1; i <= 8; i++) {
            char ch = (char) ((Math.random() * 26) + 65);
            str += ch;
        }
        for (int i = 1; i <= 8; i++) {
            char ch = (char) ((Math.random() * 26) + 97);
            str += ch;
        }
        return str;
    }
}
