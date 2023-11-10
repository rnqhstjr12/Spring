package kr.co.dong.board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {
	
	//전체목록  처리를 위한 메소드
	public List<BoardDTO> list() throws Exception;
	
	//선택목록(글읽기)을 위한 메소드
	public BoardDTO detail(int bno) throws Exception;
	
	//조회수 증가를 위한 메소드
	public int updateReadCnt(int bno) throws Exception;
	
	//글쓰기를 위한 메소드
	public int register(BoardDTO boardDTO) throws Exception;
	
	//글수정을 위한 메소드
	public int update(BoardDTO boardDTO) throws Exception;
	
	//글삭제를 위한 메소드
	public int delete(int bno) throws Exception;
	
	//댓글 전체 목록
	public List<BoardReply> getDetail(int bno) throws Exception;
	
	//댓글 쓰기
	public int reply(BoardReply boardReply) throws Exception;
	
	//해당 댓글 읽기(조회)
	public BoardReply detailReply(int reno) throws Exception;
	
	//댓글 수정
	public int replyUpdate(BoardReply boardReply) throws Exception;
	
	//댓글 삭제
	public int replyDelete(BoardReply boardReply) throws Exception;
	
	//로그인 처리를 위한 메소드
	public Map login(Map<String, Object> map);
}
