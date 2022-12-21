package com.example.imageinfo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_image")
public class BookImageEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bimg_seq")          private Long bimgSeq;
    @Column(name = "bimg_bi_seq")       private Long bimgBiSeq;
    @Column(name = "bimg_filename")     private String bimgFilename;
    @Column(name = "bimg_thumbnail")    private Long bimgThumbnail;
}
