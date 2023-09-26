package com.team2.project01.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyPageDTO {
	
	private int replyCount;
	
	private List<ReviewReplyVO> list;

}
