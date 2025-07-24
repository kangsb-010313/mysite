package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.vo.FileVO;

@Service
public class AttachService {
	
	//필드
	
	//생성자 메소드gs
	
	//메소드 일반
	
	//-- 
	public String exeUpload(MultipartFile file) {
		System.out.println("AttachService.exeUpload()");
		
		//--파일 저장 경로 
		// 윈도우 경로	--> C:\\javaStudy\\upload\\
		// 맥 경로	--> /Users/kangsubin/Desktop/javaStudy/upload/
		//String saveDir = "C:\\javaStudy\\upload\\";
		//String saveDir = "/Users/kangsubin/Desktop/javaStudy/upload/";
		
		String saveDir = "/data/upload/";
		
		//(1)파일정보를 추출 저장(DB) 
		//오리지널 파일명
		String orgName = file.getOriginalFilename(); //원래 이름으로 내려받기 위해서
		System.out.println(orgName);
		
		//확장자 
		String exName = orgName.substring(orgName.lastIndexOf(".")+1); //"."이 몇 번째 방에 있는지 --> .뒤로 잘라내라 
		System.out.println(exName); //.jpg
		
		//저장파일명(겹치지 않는 파일명 - 덮어쓰기 방지용)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + "." + exName; //현재시간 + 랜덤숫자 + .jpg
		System.out.println(saveName);
		
		//파일경로
		String filePath = saveDir+saveName;
		System.out.println(filePath);
		
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println(fileSize);
		
		//vo에 묵는다 --> db저장
		FileVO fileVO = new FileVO(orgName, exName, saveName, filePath, fileSize);
		System.out.println(fileVO);
		
		//db저장
		//과제(주황색)
		
		
		
		//(2)실물 파일을 하드디스크에 저장
		try {
			byte[] fileData = file.getBytes();
			
			//빨대
			OutputStream os= new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saveName;
		
		
		
	}

}
