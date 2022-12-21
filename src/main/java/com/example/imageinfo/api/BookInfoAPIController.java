package com.example.imageinfo.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.imageinfo.entity.BookInfoEntity;
import com.example.imageinfo.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookInfoAPIController {
    @Autowired BookService bService;
    @GetMapping("/info")
    public ResponseEntity<Object> getBookInfo(@RequestParam Long bookNo) {
        return new ResponseEntity<>(bService.getBookInfoBySeq(bookNo), HttpStatus.OK);
    }
    @PutMapping("/info")
    public ResponseEntity<Object> putBookInfo(BookInfoEntity data, List<MultipartFile> bimgs, List<MultipartFile> descimgs) {
        data.setBiRegDt(LocalDate.now());
        Map<String, Object> resultMap = bService.insertBookInfoWithFiles(data, bimgs, descimgs);
        return new ResponseEntity<>(resultMap, (HttpStatus)resultMap.get("code"));
    }
    @GetMapping("/list")
    public ResponseEntity<Object> getBookList() {
        return null;
    }
}
