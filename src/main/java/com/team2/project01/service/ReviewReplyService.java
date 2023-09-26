package com.team2.project01.service;

import java.util.List;

import com.team2.project01.domain.CriteriaVO;
import com.team2.project01.domain.ReplyPageDTO;
import com.team2.project01.domain.ReviewReplyVO;

public interface ReviewReplyService {
	
	List<ReviewReplyVO> getList(CriteriaVO criVO, Long r_id);
	
	ReplyPageDTO getListPage(CriteriaVO criVO, Long r_id);
	
	ReviewReplyVO read(Long r_r_id);

	int register(ReviewReplyVO reviewReplyVO);
	
	int modify(ReviewReplyVO reviewReplyVO);
	
	int delete(Long r_r_id);
}
