package com.team2.project1.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.team2.project01.domain.CriteriaVO;
import com.team2.project01.domain.ReviewReplyVO;
import com.team2.project01.domain.ReviewVO;
import com.team2.project01.mapper.ReviewMapper;
import com.team2.project01.mapper.ReviewReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReviewReplyMapper mapper;
	
//	@Test
//	public void testList() {
//		Criteria cri = new Criteria();
//		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);
//		replies.forEach(reply -> log.info(reply));
//	}
	
	@Test
	public void testList2() {
		CriteriaVO cri = new CriteriaVO(1, 10);
		List<ReviewReplyVO> replies = mapper.getListWithPaging(cri, 298L);
		replies.forEach(reply -> log.info(reply));
	}

//	@Test
//	public void testUpdate() {
//		
//		Long targetRno = 10L;
//		
//		ReplyVO vo = mapper.read(targetRno);
//		
//		vo.setReply("Update Reply");
//		
//		int count = mapper.update(vo);
//		
//		log.info("UPDATE COUNT: " + count);
//	}
	
//	@Test
//	public void testDelete() {
//		Long targetRno = 1L;
//		mapper.delete(targetRno);Xt
//	}
	
//	@Test
//	public void testRead() {
//		Long targetRno = 5L;
//		
//		ReplyVO vo = mapper.read(targetRno);
//		
//		log.info("read test: " + vo);
//	}
	
//	@Test
//	public void testCreate() {
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO vo = new ReplyVO();
//			
//			vo.setBno(bnoArr[i % 5]);
//			vo.setReply("댓글 테스트 " + i);
//			vo.setReplyer("replyer" + i);
//			
//			mapper.insert(vo);
//		});
//	}

//	@Test
//	public void testMapper() {
//		log.info(mapper);
//	}
}
