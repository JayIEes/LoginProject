/**
 * 
 */
package com.login.project.domain;

/**
 * 
 * @controllerName PageDTO.java
 * @package com.login.project.domain
 * @date 2023. 1. 27.
 */
public class PageDTO {
	
	// 시작 페이지, 끝 페이지, 전체 글 개수
	private int startPage, endPage, total;
	private boolean prev, next; //이전, 다음
	private int displayPageNum = 10;
	
	//요청한 페이지 번호, 한 페이지 당 게시글 개수
	private Criteria criteria;
	

	public PageDTO(Criteria criteria, int total) {
		
		this.criteria = criteria;
		this.total = total;
	
		//10은 페이지 블록을 구성 페이지 수
		//끝 페이지 번호 = (int)Math.ceil( 현재페이지 / (double)페이지 블록 개수) * 페이지 블록 개수
		this.endPage = (int)Math.ceil(criteria.getPageNum() / (double)displayPageNum) * displayPageNum;
		
		//시작 페이지 번호 = 끝 페이지 번호 - 페이지 블록 개수)
		this.startPage = (this.endPage - displayPageNum) +1;
		
		//실제 끝 페이지 번호 = (int)Math.ceil( 게시글 총 개수 / 한 페이지 당 게시글 수)
		int realEndPage = (int)Math.ceil(total / criteria.getPerPageNum());
	
		//끝 페이지 보정된 결과 대입
		if(realEndPage < this.endPage) {
			this.endPage = realEndPage;
		}
		
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEndPage;
		
	}


	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public int getDisplayPageNum() {
		return displayPageNum;
	}


	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}


	public Criteria getCriteria() {
		return criteria;
	}


	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
	
	
}
