package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //세션호출하기 위함
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlsession;
	
	private static final String namespace = "kr.co.dong.boardMapper";
	
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".login", map);
	}

	@Override
	public List<BoardDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + ".list");
	}

	@Override
	public BoardDTO detail(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".detail", bno);
	}

	@Override
	public int updateReadCnt(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".updateReadCnt", bno);
	}

	@Override
	public int register(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace+".register", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".update", boardDTO);
	}

	@Override
	public int delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".delete", bno);
	}

	@Override
	public List<BoardReply> getDetail(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + ".detail1", bno);
	}

	@Override
	public int reply(BoardReply boardReply) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace+".reply", boardReply);
	}

	@Override
	public BoardReply detailReply(int reno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".detailReply", reno);
	}

	@Override
	public int replyUpdate(BoardReply boardReply) throws Exception {  
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".replyUpdate", boardReply);
	}

	@Override
	public int replyDelete(BoardReply boardReply) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(namespace+".replyDelete", boardReply);
	}


}
