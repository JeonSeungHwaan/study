package org.mvc.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/file/")
@Slf4j
public class UploadController {
	
	private static int count = 0;
	
	@RequestMapping("uploadForm")
	public String uploadForm() {
		return "1203/uploadForm";
	}
	
	@RequestMapping("uploadPro")
	// MultipartFile - 업로드 된 파일이 올라가는 클래스
	public String uploadPro(String name, MultipartFile save, Model model) {
		
		// "/" 를 기준으로 문자열을 자름(String 배열로 리턴)
		// type = type.split("/")[0]; - 리펙토링 코딩 (코드를 줄여서 작성하는 것)	
		String type = save.getContentType().split("/")[0]; // image / jpeg
		
		String orgName = save.getOriginalFilename();
		
		/*
		 * String [] s = type.split("/");
		 * type = s[0]; 
		 */
		
		if(type.equals("image")) {
			
			// 파일명 중복 처리
			File folder = new File("E://fileSave//");
			String [] list = folder.list();
			
			for(String fileName : list) {
				if(fileName.equals(orgName)){
					orgName = (++count) + orgName;
				}
			}
			
			// 파일 업로드
			File f = new File("E://fileSave//"+orgName);
			try {
				save.transferTo(f); // 업로드
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return "1203/uploadPro";
	}
	
	@RequestMapping("test")
	public String test(Exception e, String str) {
		log.error("Exception---"+e.getMessage());
		return "1203/uploadForm";
	}
}
