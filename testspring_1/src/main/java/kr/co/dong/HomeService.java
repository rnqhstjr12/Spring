package kr.co.dong;

import org.springframework.stereotype.Service;

@Service //ctrl+space눌러서 import 해놓고 시작! 어노테이션 꼭 사용하기 !!!!!!!!!!!!!!
public class HomeService {
	public String testM() {
		return "이순신";
	}
	
	public String testM2() {
		return "홍길동";
	}
}
