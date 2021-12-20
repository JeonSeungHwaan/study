package org.mvc.controller;

import java.util.List;

import org.mvc.bean.BoardDTO;
import org.mvc.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/")
public class BoardController {
	
	// BoardServiceImpl 객체가 컨트롤에서 대입됨
	@Autowired
	private BoardService service; 
	
	@RequestMapping("list")
	public String list(Model model) {
		List<BoardDTO> list = service.getList();
		log.info("BoardList = " + list);
		
		// views 로 값 전달
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("write")
	public String write() {
		log.info("=============/board/write/=============");
		return "board/write";
	}
	
	@RequestMapping("writePro")
	public String writePro(BoardDTO board, Model model) {
		log.info("=============/board/writePro/=============");
		
		model.addAttribute("result", service.boardWrite(board));
		
		return "board/writePro";
	}
	
	// 조회수 증가 후 컨텐츠 페이지로 이동
	@RequestMapping("readcount")
	public String readcount(Long bno, RedirectAttributes rttr) {
		log.info("=============/board/readcount?bno="+bno+"/=============");
		service.boardReadCount(bno);
		
		// rttr.addAttribute - 리다이렉트로 이동할 때 파라미터를 넘기는 클래스
		// model.addAttribute 와 같은 역할을 함 (리다이렉트 할 때만 넘겨주겠다는 것만 다름)
		rttr.addAttribute("bno", bno);
		
		return "redirect:/board/content";
	}
	
	@RequestMapping("content")
	public String content(Long bno, Model model) {
		log.info("=============/board/content?bno="+bno+"/=============");
		model.addAttribute("boardDTO", service.getBnoRead(bno));
		return "board/content";
	}
	
	@RequestMapping("update")
	public String update(BoardDTO board) {
		log.info("=============/board/update?bno="+board.getBno()+"/=============");
		return "board/update";
	}
	
	@RequestMapping("updatePro")
	public String updatePro(BoardDTO board, Model model) {
		log.info("=============/board/updatePro?bno="+board.getBno()+"/=============");
		model.addAttribute("result", service.updateContent(board));
		return "board/updatePro";
	}
	
	@RequestMapping("delete")
	public String delete(@ModelAttribute("bno") Long bno) { // @ModelAttribute - delete.jsp 로 받은 파라미터 값을 바로 보내줌
		log.info("=============/board/delete?bno="+bno+"/=============");
		
		return "board/delete";
	}
	
	@RequestMapping("deletePro")
	public String deletePro(Long bno, Model model) {
		log.info("=============/board/deletePro?bno="+bno+"/=============");
		model.addAttribute("result", service.deleteContent(bno));
		return "board/deletePro";
	}
}
