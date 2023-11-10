package kr.co.dong;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//인스턴스화 사용하는법 : 강한결합
//	HomeService homeService = new HomeService();
	//참조형으로 사용하는법
	@Inject	//@Autowired(어노테이션) : spring 전용
	HomeService homeService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
	}
	
	@RequestMapping(value= "/main", method= RequestMethod.GET)
	public ModelAndView main() {
		//정보를 전송하는 model과 view 페이지를 설정하는 클래스
		ModelAndView mav = new ModelAndView();
		//Service호출 - 기능을 수행한다.
		String name = homeService.testM();
		mav.addObject("name", name);	//정보저장
		mav.setViewName("main");		//view
		return mav;
		
	}
	
	
//	public String main(Model model) {
//		logger.info("메인입니다.");
//		model.addAttribute("name","홍길동");
//		return "main";
//	}
	
	
}
