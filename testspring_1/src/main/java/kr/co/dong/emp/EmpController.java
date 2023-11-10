/* Controller의 역할
 * 1)요청한 정보를 매핑.
 * 2)해당 서비스 호출.
 * 3)결과값을 모델에 저장후, view에 리턴
 * 
 * - Controller는 Service를 호출
 * - @Controller
 */
package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Inject
	private EmpService service;
	
	//@RequestMapping -> @GetMapping / @PostMapping
	@RequestMapping(value="empCount")
	public String empCount(Model model) throws Exception {
		int cnt = service.empCount();
		model.addAttribute("cnt",cnt);
		return "home";
	}
	
	@RequestMapping(value="listAll")
	public ModelAndView listAll() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = service.listAll();
		mav.addObject("list",list);
		mav.setViewName("list");
		return mav;
	}
	
	//사원추가 폼으로 이동
	@RequestMapping(value="addEmp", method=RequestMethod.GET)
	public ModelAndView addEmp() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addEmp");
		return mav;
	}
	
	// 사원추가 DB 저장
	@RequestMapping(value="addEmp", method = RequestMethod.POST)
	public String addEmpDao(EmpVO empVO) throws Exception {
		System.out.println(empVO);
		ModelAndView mav = new ModelAndView();
		//service 사원추가메소드 호출
		int r = service.insert(empVO);
		
		return "redirect:listAll";
	}
	
	//사원추가 DB 저장_위랑 같음
//		@RequestMapping(value="addEmp", method=RequestMethod.POST)
//		public ModelAndView addEmpDao(EmpVO empVO) throws Exception {
//			System.out.println(empVO);
//			ModelAndView mav = new ModelAndView();
//			//service 사원추가메소드 호출
//			service.insert(empVO);
//			
//			//redirct or forward or 다시 call
//			List<EmpVO> list = service.listAll();
//			mav.addObject("list",list);
//			mav.setViewName("list");
//			return mav;
//		}
}
