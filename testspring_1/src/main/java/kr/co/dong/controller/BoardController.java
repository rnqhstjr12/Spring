package kr.co.dong.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.dong.board.BoardDTO;
import kr.co.dong.board.BoardReply;
import kr.co.dong.board.BoardService;
import kr.co.dong.board.PageCreate;
import kr.co.dong.board.PageVO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService service;
	
//	로그인 폼으로 가는 매핑 board/login -> login(.jsp)
	@RequestMapping(value="board/login", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
//	로그인 폼으로 가는 매핑 board/login -> login(.jsp)
	@GetMapping(value="board/logOut")
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
//	로그인 처리하기 (DAO)  : 성공하면 redirect:/ (또는 home.jsp)
//	                           세션부여함.
	@RequestMapping(value="board/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String,Object> map,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println(map);
		// 서비스 호출
		Map user = service.login(map);
		
		if(user == null) {  // 로그인 실패
			
			return "redirect:login";
		}else {   // 로그인 성공
			// 세션 부여
			session.setAttribute("user", user);
			return "redirect:/";
		}		
	}
	
	@RequestMapping(value="board/list", method = RequestMethod.GET)
	   public ModelAndView list(PageVO vo) throws Exception {
	      /*
	      logger.info("=========list==========");
	      ModelAndView mav = new ModelAndView();
	      
	      List<BoardDTO> list = service.list();
	      mav.addObject("list", list);
	      mav.setViewName("list");
	      */
	      ModelAndView mav = new ModelAndView();
	      PageCreate pc = new PageCreate();
	      pc.setPaging(vo);
	      pc.setArticleTotalCount(service.getTotal());
	      
	      System.out.println("!!!!pc = "+pc);
	      
	      mav.addObject("list", service.getFreeBoard(vo));
	      mav.addObject("pc", pc);
	      mav.setViewName("list");

	      return mav;
	   }
	
	@RequestMapping(value="board/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardDTO board = service.detail(bno);
		model.addAttribute("board", board);
		//댓글목록
		List<BoardReply> list = service.getDetail(bno);
		model.addAttribute("list", list);
		return "detail";
	}
//	글쓰기폼
	@RequestMapping(value="board/register", method = RequestMethod.GET)
	public String register() {
		
		return "register";
	}
//	글쓰기 저장
	@RequestMapping(value="board/register", method = RequestMethod.POST)
	public String register(BoardDTO boardDTO, HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		logger.info("내용 : " + boardDTO);
		
		int r = service.register(boardDTO);
		
		return "redirect:list";
	}
	
	
//	글 수정 폼(기존데이터 전송- 글읽기)
	@RequestMapping(value="board/update", method = RequestMethod.GET)
	public String update(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardDTO board = service.detail(bno);
		model.addAttribute("board", board);		
		return "update";
	}	
//	글 수정 저장
	@RequestMapping(value = "board/update", method = RequestMethod.POST)
	public String update(BoardDTO boardDTO, RedirectAttributes rttr,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		int r = service.update(boardDTO);
		// 수정에 성공하면 목록보기로 이동
		if (r > 0) {
			rttr.addFlashAttribute("msg", "수정에 성공 하였습니다.");
			return "redirect:list";
		}
		// 수정에 실패하면 수정보기 화면으로 이동
		return "redirect:update?bno=" + boardDTO.getBno();
	}
	
	@RequestMapping(value="board/delete",method = RequestMethod.GET)
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {
		int r = service.delete(bno);
		
		if(r > 0) {
			rttr.addFlashAttribute("msg","글삭제에 성공하였습니다.");
			return "redirect:list";
		}
		return "redirect:detail?bno=" + bno;
	}
	
	@GetMapping(value="board/reply")
	public String reply() {
		return "reply";
	}
	
	@PostMapping(value="board/reply")
	public String reply(BoardReply boardReply) throws Exception {
		int r = service.reply(boardReply);
		if(r>0) {
			return "redirect:detail?bno=" + boardReply.getBno();
		}
		return "reply";
	}

	@GetMapping(value="board/replyupdate")
	public String replyUpdate(@RequestParam("reno")int reno, Model model) throws Exception {
		BoardReply boardReply = service.detailReply(reno);
		model.addAttribute("boardReply", boardReply);
		return "replyupdate";
	}
	
	@PostMapping(value="board/replyupdate")
	public String replyUpdate(BoardReply boardReply) throws Exception {
		logger.info("!!!!!!!!!!!!!");
		int r = service.replyUpdate(boardReply);
		if(r>0) {
			return "redirect:detail?bno="+boardReply.getBno();
		}
		return "replyupdate";
	}
	
	@RequestMapping(value="board/replyDelete", method = {RequestMethod.GET, RequestMethod.POST})
	public String replyDelete(BoardReply boardReply) throws Exception {
		logger.info("!!!!!!!!!!!!!"+boardReply.getBno());
		int r = service.replyDelete(boardReply);
		if(r>0) {
			return "redirect:detail?bno="+boardReply.getBno();
		}
		return "replyupdate";
	}
	
}






