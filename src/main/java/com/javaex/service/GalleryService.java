package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.GalleryRepository;
import com.javaex.vo.GalleryVO;

@Service
public class GalleryService {
	
	//필드
	@Autowired
	private GalleryRepository galleryRepository;
	
	
	//메소드 일반
	//갤러리 전체 리스트(첫 화면)
	public List<GalleryVO> exeGalleryList() {
		System.out.println("GalleryService.exeGalleryList()");
		
		List<GalleryVO> gaList =  galleryRepository.gallerySelectList();
		
		return gaList;
	}
	
	//갤러리 업로드 등록(저장)
	public int exeGalleryUpload(GalleryVO galleryVO) {
		System.out.println("GalleryService.exeGalleryUpload()");
		
		int count = galleryRepository.galleryInsert(galleryVO);
		
		return count;
	}

}
