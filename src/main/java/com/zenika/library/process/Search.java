package com.zenika.library.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Search implements Serializable {

	public Search() {
		super();
	}

	public Search(String searchTerm, Integer page) {
		super();
		this.searchTerm = searchTerm;
		this.page = page;
	}

	@Id
	/** SearchTerm */
	private String searchTerm;
	
	/** Page */
	private Integer page;

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
