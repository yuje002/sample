package com.example.imageinfo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.imageinfo.entity.BookInfoEntity;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfoEntity, Long>{
    public BookInfoEntity findByBiSeq(Long biSeq);
    public Page<BookInfoEntity> findAll(Pageable pageable);
}
