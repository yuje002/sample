package com.example.imageinfo.api;

import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileAPIController {
    @Value("${file.image.book}") String bookImgPath;
    @Value("${file.image.description}") String bookDescImgPath;
    @GetMapping("/images/{type}/{filename}")
    public ResponseEntity<Object> downloadImageFile(@PathVariable String type, @PathVariable String filename, HttpServletRequest request) throws Exception {
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
            return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
        }
        Path targetFile = baseDir.resolve(filename);
        Resource r = null;
        String contentType = null;
        try {
            r = new UrlResource((targetFile.toUri()));
            contentType = request.getServletContext().getMimeType(r.getFile().getAbsolutePath());
            if(contentType == null) {
                contentType = "application/octet-stream";
            }
        }
        catch(Exception e) {
            resultMap.put("status", false);
            resultMap.put("message", "File "+filename+" is not exists");
            return new ResponseEntity<>(resultMap, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ URLEncoder.encode(filename, "UTF-8")+"\"")
        .body(r);
    }

}
