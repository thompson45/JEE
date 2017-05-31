package com.zenika.library.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PodiumItemCreationRequest implements Serializable {
	
	public PodiumItemCreationRequest() {
		super();
	}

	public PodiumItemCreationRequest(String name, String imageUrl) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
	}
	
	@Id
	/** Name */
	private String name;

	/** ImageUrl */
	private String imageUrl;

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
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
