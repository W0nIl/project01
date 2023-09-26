package com.team2.project1.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team2.project01.domain.ReviewReplyVO;
import com.team2.project01.mapper.ReviewReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReviewReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReviewReplyMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(review -> log.info(review));
//	}
	
	@Test
	public void testInsert() {
		ReviewReplyVO reply = new ReviewReplyVO();
		for(int i = 1; i <= 900; i++) {
			Long r_id = (long)(Math.random() * 300 + 1);
			reply.setR_id(r_id);
			reply.setR_r_title("title" + i);
			reply.setR_r_content("content" + i);
			reply.setR_r_writer("user" + i);
			mapper.insert(reply);
		}
		
		log.info(reply);
	}
	
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//		
//		mapper.insertSelectKey(board);
//		
//		log.info(board);
//	}

//	@Test
//	public void testRead() {
//		ReviewVO board = mapper.read(22L);
//		log.info(board);
//	}
	
//	@Test
//	public void testDelete() {
//		log.info("DELETE COUNT: " + mapper.delete(3L));
//	}

//	@Test
//	public void testUpdate() {
//		BoardVO board = new BoardVO();
//		board.setBno(5L);
//		board.setTitle("수정된 제목");
//		board.setContent("수정된 내용");
//		board.setWriter("user00");
//		
//		int count = mapper.update(board);
//		log.info("UPDATE COUNT: " + count);
//	}
	
//	@Test
//	public void testPaging() {
//		Criteria cri = new Criteria();
//		
//		cri.setPageNum(3);
//		cri.setAmount(10);
//		
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		list.forEach(board -> log.info(board));
//	}
	
//	@Test
//	public void testSearch() {
//		Criteria cri = new Criteria();
//		cri.setKeyword("아무개");
//		cri.setType("W");
//		
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		list.forEach(board -> log.info(board));
//	}
	
}
