package kr.co.dong.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.net.AbstractEndpoint.Handler;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {

   
   // Controller가 요청을 처리하기 전에 호출하는 메소드
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      // 클라이언트에게 부여한 세션을 가져온다.
      HttpSession session = request.getSession();
      if(session.getAttribute("user") == null) {
         // 세션이 없으면 통과 못함 -> 로그인 써 줘야 한다는 거 
            // ▶ 로그인 안 되어 있으니까 로그인 창으로 이동시킴!
         response.sendRedirect(request.getContextPath() + "board/login");
                              // ▶ 내용 경로를 가져오는 게터
         return false;
      }
      return true; // 로그인 되어 있으면 그냥 통과
   }

   
   // Controller가 요청을 처리한 후에 호출하는 메소드
   // 예외가 발생되지 않은 경우에만 Controller 작업 후에 호출되는 메소드
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
         ModelAndView modelAndView) throws Exception {
      // TODO Auto-generated method stub
      
   }
   
   // Controller가 요청을 처리한 후에 호출하는 메소드
   // 예외 발생여부에 상관 없이 Controller 작업 후에 호출되는 메소드
   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
         throws Exception {
      // TODO Auto-generated method stub
      
   }

}