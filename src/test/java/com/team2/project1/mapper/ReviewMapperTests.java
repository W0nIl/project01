package com.team2.project1.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team2.project01.domain.CriteriaVO;
import com.team2.project01.domain.ReviewVO;
import com.team2.project01.mapper.ReviewMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReviewMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReviewMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(review -> log.info(review));
//	}
	
//	@Test
//	public void testInsert() {
//		ReviewVO review = new ReviewVO();
//		for(int i = 1; i <= 300; i++) {
//			review.setR_title("title" + i);
//			review.setR_content("content" + i);
//			review.setR_writer("user" + i);
//			mapper.insert(review);
//		}
//		
//		log.info(review);
//	}
	
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
	
	@Test
	public void testPaging() {
		CriteriaVO criVO = new CriteriaVO();
		
		criVO.setPage(3);
		criVO.setSize(10);
		
		List<ReviewVO> list = mapper.getList(criVO);
		list.forEach(review -> log.info(review));
	}
	
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
