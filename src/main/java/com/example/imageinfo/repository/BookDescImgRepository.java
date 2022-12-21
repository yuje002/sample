package com.example.imageinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.imageinfo.entity.BookDescImgEntity;

@Repository
public interface BookDescImgRepository extends JpaRepository<BookDescImgEntity, Long>{
    List<BookDescImgEntity> findByBdiBiSeq(Long bdiBiSeq);
}
