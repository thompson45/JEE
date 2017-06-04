package com.zenika.library.process;

public class PodiumItem {
	private String name;
	private Integer points;
	private String imageUrl;
	
	/**
	 * 
	 */
	public PodiumItem() {
		super();
	}
	/**
	 * @param name
	 * @param points
	 * @param imageUrl
	 */
	public PodiumItem(String name, Integer points, String imageUrl) {
		super();
		this.name = name;
		this.points = points;
		this.imageUrl = imageUrl;
	}
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
	 * @return the points
	 */
	public Integer getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(Integer points) {
		this.points = points;
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
