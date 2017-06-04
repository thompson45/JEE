package com.zenika.library.process;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.zenika.library.data.PodiumDAO;

public class Podium implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5372301494130311388L;

	/** Id */
	private Integer id;

	/** Name */
	private String name;

	/** NumberOfVotes */
	private Integer numberOfVotes;
	
	/** Items */
	private List<PodiumItem> items;


	/**
	 * 
	 */
	public Podium() {
		super();
	}
	
	/**
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public Podium(PodiumDAO p1, PodiumDAO p2, PodiumDAO p3) {
		super();
		this.id = p1.getIdPodium();
		this.name = p1.getName();
		this.numberOfVotes = p1.getNumberOfVotes();
		this.items = new ArrayList<PodiumItem>();
		this.items.add(new PodiumItem(p1.getNameItem(),p1.getPoints(),p1.getImageUrl()));
		this.items.add(new PodiumItem(p2.getNameItem(),p2.getPoints(),p2.getImageUrl()));
		this.items.add(new PodiumItem(p3.getNameItem(),p3.getPoints(),p3.getImageUrl()));
	}

	/**
	 * @param name
	 * @param numberOfVotes
	 * @param items
	 */
	public Podium(String name, Integer numberOfVotes, List<PodiumItem> items) {
		super();
		this.name = name;
		this.numberOfVotes = numberOfVotes;
		this.items = items;
	}

	/**
	 * @param id
	 * @param name
	 * @param numberOfVotes
	 * @param items
	 */
	public Podium(Integer id, String name, Integer numberOfVotes, List<PodiumItem> items) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfVotes = numberOfVotes;
		this.items = items;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the numberOfVotes
	 */
	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	/**
	 * @param numberOfVotes the numberOfVotes to set
	 */
	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	/**
	 * @return the items
	 */
	public List<PodiumItem> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<PodiumItem> items) {
		this.items = items;
	}
}