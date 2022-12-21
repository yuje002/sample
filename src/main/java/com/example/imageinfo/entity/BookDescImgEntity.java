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
@Table(name = "book_description_image")
public class BookDescImgEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bdi_seq")       private Long bdiSeq;
    @Column(name = "bdi_bi_seq")    private Long bdiBiSeq;
    @Column(name = "bdi_filename")  private String bdiFilename;
    // @Column(name = "bdi_order")     private Long bdiOrder;
}
