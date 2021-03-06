package com.test.service;

import java.util.List;

import com.test.domain.BoardVO;
import com.test.domain.Criteria;

public interface BoardService {
	
	// create
	public void create(BoardVO vo) throws Exception;
	
	// read
	public BoardVO read(int bno) throws Exception;
	
	// update
	public void update(BoardVO vo) throws Exception;
	
	// delete
	public void delete(int bno) throws Exception;
	
	// list
	public List<BoardVO> list() throws Exception;
	
	// list + paging
	public List<BoardVO> listPage(int listpage) throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	// page Count
	public int countPaging(Criteria cri) throws Exception;
	
	// Search
	public List<BoardVO> listSearch(Criteria cri) throws Exception;
	
	// Search page Count
	public int listSearchCount(Criteria cri) throws Exception;
}
