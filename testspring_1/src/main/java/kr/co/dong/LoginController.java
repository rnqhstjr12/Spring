package kr.co.dong;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="login/loginForm", method = RequestMethod.GET) //하이퍼링크는 get 방식으로 사용함
	public ModelAndView loginForm() {
		logger.info("로그인 폼 처리화면 입니다.");
		ModelAndView mav = new ModelAndView();
		mav.addObject("test", "test Model");
		mav.setViewName("login/loginForm");
		return mav;
	}
	
//	1.request 파라미터 전달받는 방법1
	@RequestMapping(value="login/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");	//한글처리
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		//Service 호출했다치고(DB 안가는 방식)
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("name", name);
		mav.setViewName("login/result");
		
		return mav;
	}
	
//	2.request 파라미터를 전달받는 방법2 -> @RequestParam
	@RequestMapping(value="login/login2", method = RequestMethod.POST)
	public ModelAndView login2(@RequestParam("userId") String userId, 
			@RequestParam("name") String name, HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");	
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("name", name);
		mav.setViewName("login/result");
		return mav;
	}
	
//	3.request 파라미터 전달 받는 방법3 -> Map<String, Object> map
	@RequestMapping(value="login/login3", method= RequestMethod.POST)
	public ModelAndView login3(@RequestParam Map<String,String> info) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("info", info);
		mav.setViewName("login/result");
		return mav;
	} 
	
//	4.request 파라미터 전달 받는 방법4 -> Bean class / UserVO.java 파일 만들어서 사용하기
	@RequestMapping(value="login/login4", method= RequestMethod.POST)
	public ModelAndView login4(@ModelAttribute("info") UserVO uservo) {
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("info", uservo);
		mav.setViewName("login/result");
		return mav;
	}
	
}
