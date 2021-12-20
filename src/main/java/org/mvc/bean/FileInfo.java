package org.mvc.bean;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileInfo {
	
	/*  
	 *  프로필 사진 업로드
	 *  1. 파일 유무 확인 
	 *  2. 파일 확장자 확인(img 파일인지) 
	 *  3. 파일 저장 (/resourcse/member/img 파일 저장) 
	 *  4. DB tbl_member / id에 대한 img 이름 저장
	 */
	
	// 2. 파일 확장자 확인
	public boolean fileTypeCheck(MultipartFile file, String type) {
		boolean result = false;
		
		String fileType = file.getContentType().split("/")[0];
		if(fileType.equals(type)) {
			result = true;
		}
		return result;
	}
}
