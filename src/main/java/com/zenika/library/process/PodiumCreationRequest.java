package com.zenika.library.process;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PodiumCreationRequest implements Serializable {

	public PodiumCreationRequest() {
		super();
	}

	public PodiumCreationRequest(String name, List<PodiumItemCreationRequest> items) {
		super();
		this.name = name;
		this.items = items;
	}

	@Id
	/** Name */
	private String name;
	
	/** PodiumItemCreationRequest */
	private List<PodiumItemCreationRequest> items;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the items
	 */
	public List<PodiumItemCreationRequest> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<PodiumItemCreationRequest> items) {
		this.items = items;
	}
}
