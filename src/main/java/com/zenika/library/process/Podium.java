package com.zenika.library.process;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Podium")
public class Podium implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5372301494130311387L;

	public Podium(String name, Integer numberOfVotes, List<PodiumItem> items) {
		super();
		this.name = name;
		this.numberOfVotes = numberOfVotes;
		this.items = items;
	}

	public Podium(Integer id, String name, Integer numberOfVotes, List<PodiumItem> items) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfVotes = numberOfVotes;
		this.items = items;
	}

	public Podium() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	/** Id */
	@Column(name ="id")
	private Integer id;

	@Column(name ="name")
	/** Name */
	private String name;

	@Column(name ="numberOfVotes")
	/** NumberOfVotes */
	private Integer numberOfVotes;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "items")
	@Transient
	/** PodiumItem */
	private List<PodiumItem> items;

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