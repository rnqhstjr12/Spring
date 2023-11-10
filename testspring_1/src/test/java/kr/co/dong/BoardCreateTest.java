package kr.co.dong;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//���� ���ㅽ�� 肄���瑜� �ㅽ���� �� �ㅽ��留��� 濡��� ����濡� ���� 遺�遺�.

import kr.co.dong.board.BoardDAO;
import kr.co.dong.board.BoardDTO;
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class BoardCreateTest {
    
	@Inject
	private BoardDAO boardDAO;
	
	@Test
	public void testInsert() throws Exception {
		BoardDTO board;
		
		for(int i =1; i<1000; i++) {
			board = new BoardDTO();
			board.setTitle("test title["+i+"]");
			board.setContent("test content - " + i);
			board.setId("root");
			boardDAO.register(board); 
			
			Thread.sleep(1000); 
		}
	}

}

