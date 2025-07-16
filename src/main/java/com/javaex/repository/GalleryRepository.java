package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVO;

@Repository
public class GalleryRepository {
	
	//필드
	@Autowired
	private SqlSession sqlSession;

	
	//메소드 일반
	//갤러리 전체 리스트(첫 화면)
	public List<GalleryVO> gallerySelectList() {
		System.out.println("GalleryRepository.gallerySelectList()");
		
		List<GalleryVO> gaList =  sqlSession.selectList("gallery.selectList");
		
		return gaList;
	}
	
	
	//갤러리 업로드 등록(저장)
	public int galleryInsert(GalleryVO galleryVO) {
		System.out.println("GalleryRepository.galleryInsert()");
		
		int count = sqlSession.insert("gallery.insert", galleryVO);
		
		return count;
	}
	
	
	//갤러리 삭제
	public void galleryDelete() {
		System.out.println("GalleryRepository.galleryDelete()");
		
		sqlSession.delete("gallery.delete");
	}
	
	
	
}
