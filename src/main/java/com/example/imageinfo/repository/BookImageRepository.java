package com.example.imageinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.imageinfo.entity.BookImageEntity;

@Repository
public interface BookImageRepository extends JpaRepository<BookImageEntity, Long>{
    List<BookImageEntity> findByBimgBiSeq(Long bimgBiSeq);
    
}
