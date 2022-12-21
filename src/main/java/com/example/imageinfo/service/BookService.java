package com.example.imageinfo.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.imageinfo.entity.BookDescImgEntity;
import com.example.imageinfo.entity.BookImageEntity;
import com.example.imageinfo.entity.BookInfoEntity;
import com.example.imageinfo.repository.BookDescImgRepository;
import com.example.imageinfo.repository.BookImageRepository;
import com.example.imageinfo.repository.BookInfoRepository;

@Service
public class BookService {
    @Autowired BookDescImgRepository bdiRepo;
    @Autowired BookImageRepository bimgRepo;
    @Autowired BookInfoRepository biRepo;
    @Autowired FileService fileService;

    public Map<String, Object> insertBookInfoWithFiles(BookInfoEntity data, List<MultipartFile> bimgs, List<MultipartFile> descimgs) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        biRepo.save(data);
        if(bimgs != null) {
            Map<String, Object> map = fileService.uploadFiles("book", bimgs);
            List<String> filelist = (List<String>)map.get("filelist");
            Long thumb = 1L;
            for(String filename : filelist) {
                BookImageEntity imgData = new BookImageEntity(null, data.getBiSeq(), filename, thumb);
                thumb = 0L;
                bimgRepo.save(imgData);
            }
        }
        if(descimgs != null) {
            Map<String, Object> map = fileService.uploadFiles("desc", descimgs);
            List<String> filelist = (List<String>)map.get("filelist");
            for(String filename : filelist) {
                BookDescImgEntity imgData = new BookDescImgEntity(null, data.getBiSeq(), filename);
                bdiRepo.save(imgData);
            }
        }
        resultMap.put("status", true);
        resultMap.put("message", "도서정보가 추가되었습니다.");
        resultMap.put("data", data);
        resultMap.put("code", HttpStatus.CREATED);
        return resultMap;
    }
    public Map<String, Object> getBookSummaryList(Pageable pageable) {
        return null;
    }

    public Map<String, Object> getBookInfoBySeq(Long seq) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        BookInfoEntity data = biRepo.findByBiSeq(seq);
        List<BookImageEntity> imgList = bimgRepo.findByBimgBiSeq(seq);
        List<BookDescImgEntity> descImgList = bdiRepo.findByBdiBiSeq(seq);
        List<String> imgFileList = new ArrayList<String>();
        List<String> imgDescList = new ArrayList<String>();
        
        for(BookImageEntity img : imgList) {
            imgFileList.add("images/book/"+img.getBimgFilename());
        }
        for(BookDescImgEntity img : descImgList) {
            imgDescList.add("images/desc/"+img.getBdiFilename());
        }
        resultMap.put("book", data);
        resultMap.put("bookimg", imgFileList);
        resultMap.put("descriptionimg", imgDescList);
        return resultMap;
    }
}
