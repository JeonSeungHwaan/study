package org.mvc.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mvc.bean.FileInfo;
import org.mvc.bean.MemberDTO;
import org.mvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService service; // MemberServiceImpl 객체가 주입
	@Autowired
	private FileInfo fileInfo;
	
	@RequestMapping("main")
	public String main() {
		return "member/main";
	}
	
	@RequestMapping("input")
	public String input() {
		log.info("=========input===========");
		return "member/input";
	}
	
	@RequestMapping("inputPro")
	public String inputPro(MemberDTO dto, MultipartFile save, Model model, HttpServletRequest req) {
		log.info("=========inputPro"+dto+save+"===========");
		
		model.addAttribute("result", service.memberInsert(dto));
	
		/*  프로필 사진 업로드
		 *  1. 파일 유무 확인 
		 *  2. 파일 확장자 확인(img 파일인지) 
		 *  3. 파일 저장 (/resourcse/member/img 파일 저장) 
		 *  4. DB tbl_member / id에 대한 img 이름 저장
		 */

		// 1. 파일 유무 확인
		if(save != null) {
			// 2. 파일 확장자 확인 메소드 호출
			if(fileInfo.fileTypeCheck(save, "image")) {
				// 3. 파일 저장
				// 사용자가 업로드한 파일 이름을 가져와서 확장자만 추출함
				String orgName = save.getOriginalFilename();
				
				// orgName.substring() - orgName 값의 ()번째부터 마지막까지 잘라낸다 
				// orgName.lastIndexOf(".") - orgName 값의 마지막 . 의 위치를 찾는다
				String ext = orgName.substring(orgName.lastIndexOf(".")); 
				
				// 사용자의 ID + 확장자 명으로 파일 이름 변경 후 파일 저장
				String fileName = dto.getId() + ext;
				
				// String path = req.getRealPath("/resources/member/img");
				String path = req.getSession().getServletContext().getRealPath("/resources/member/img");
				
				// 3. 파일 저장
				File f = new File(path+"//"+fileName);
				try {
					save.transferTo(f);
				}catch(Exception e) {
					e.printStackTrace();
				}
				 // 4. DB tbl_member 에 파일 이름 저장
				dto.setImg(fileName);
				service.memberImgUpdate(dto);
			}
		}
		
		return "member/inputPro";
	}
	
	@RequestMapping("login")
	public String login() {
		log.info("==========login===========");
		return "member/login";
	}
	
	@RequestMapping("loginPro")
	public String loginPro(MemberDTO member, HttpSession session) {
		log.info("==========loginPro===========");
		if(service.memberLogin(member) == 1) {
			session.setAttribute("memId", member.getId());
		}
		
		return "member/loginPro";
	}
	
	@RequestMapping("logout")
	public String member_logout(HttpSession session) {
		log.info("==========logout===========");
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("userInfo")
	public String member_userInfo(HttpSession session, Model model) {
		log.info("==========userInfo===========");
		String id = (String)session.getAttribute("memId");
		model.addAttribute("memberDTO", service.memberInfo(id));
		return "member/userInfo";
	}
	
	@RequestMapping("imgUpdate")
	public String member_imgUpdate() {
		log.info("==========imgUpdate===========");
		return "member/imgUpdate";
	}
	
	@RequestMapping("imgUpdatePro")
	public String member_imgUpdatePro(MultipartFile save, HttpServletRequest req, MemberDTO member, Model model) {
		log.info("==========imgUpdatePro===========");
		
		// 1. 파일 유무 확인
		if(save != null) {
			// 2. 파일 확장자 확인 메소드 호출
			if(fileInfo.fileTypeCheck(save, "image")) {
				// 3. 파일 저장
				// 사용자가 업로드한 파일 이름을 가져와서 확장자만 추출함
				String orgName = save.getOriginalFilename();
				
				// orgName.substring() - orgName 값의 ()번째부터 마지막까지 잘라낸다 
				// orgName.lastIndexOf(".") - orgName 값의 마지막 . 의 위치를 찾는다
				String ext = orgName.substring(orgName.lastIndexOf(".")); 
						
				// 사용자의 ID + 확장자 명으로 파일 이름 변경 후 파일 저장
				String fileName = member.getId() + ext;
						
				// String path = req.getRealPath("/resources/member/img");
				String path = req.getSession().getServletContext().getRealPath("/resources/member/img");
						
				// 3. 파일 저장
				File f = new File(path+"//"+fileName);
				try {
					save.transferTo(f);
				}catch(Exception e) {
					e.printStackTrace();
				}
				 // 4. DB tbl_member 에 파일 이름 저장
				member.setImg(fileName);
				service.memberImgUpdate(member);
			}
		}
		return "member/imgUpdatePro";
	}
	
	@RequestMapping("delete")
	public String member_delete() {
		log.info("==========delete===========");
		return "member/delete";
	}
	
	@RequestMapping("deletePro")
	public String member_deletePro(MemberDTO member, Model model, HttpSession session) {
		log.info("==========deletePro===========");
		int result = service.memberLogin(member);
		
		if(result == 1) {
			result = service.memberDelete(member.getId());
			session.invalidate();
		}
		model.addAttribute("result", result);
		return "member/deletePro";
	}
	
	@RequestMapping("update")
	public String member_update(Model model, MemberDTO member) {
		log.info("==========update===========");
		model.addAttribute("memberDTO", service.memberInfo(member.getId()));
		return "member/update";
	}
	
	@RequestMapping("updatePro")
	public String member_updatePro(MemberDTO member, Model model) {
		log.info("==========updatePro===========");
		model.addAttribute("result", service.memberUpdate(member));
		return "member/updatePro";
	}
}
