/**
 * 
 */
package com.login.project.domain;

/**
 * 
 * @controllerName Criteria.java
 * @package com.login.project.domain
 * @date 2023. 1. 27.
 */
public class Criteria {
	
	private int pageNum; //현재 페이지 
	private int perPageNum;  //한 페이지 당 게시글 개수 
	
	public Criteria() {
		this(1, 20);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.perPageNum = amount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	
	
}
