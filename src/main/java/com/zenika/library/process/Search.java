package com.zenika.library.process;

public class Search {

	private String searchTerm;
	
	private Integer page;

	/**
	 * @param searchTerm
	 * @param page
	 */
	public Search(String searchTerm, Integer page) {
		super();
		this.searchTerm = searchTerm;
		this.page = page;
	}

	/**
	 * 
	 */
	public Search() {
		super();
		this.page = 10;
	}

	/**
	 * @return the searchTerm
	 */
	public String getSearchTerm() {
		return searchTerm;
	}

	/**
	 * @param searchTerm the searchTerm to set
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}
	
}
