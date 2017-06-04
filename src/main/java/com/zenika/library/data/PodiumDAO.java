package com.zenika.library.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.zenika.library.process.Podium;

@Entity
@Table(name="Podium")
public class PodiumDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5372301494130311387L;


	/**
	 * 
	 */
	public PodiumDAO() {
		super();
	}

	/**
	 * @param id
	 * @param idPodium
	 * @param idPodiumItem
	 * @param name
	 * @param numberOfVotes
	 * @param nameItem
	 * @param points
	 * @param imageUrl
	 */
	public PodiumDAO(Integer id, Integer idPodium, Integer idPodiumItem, String name, Integer numberOfVotes,
			String nameItem, int points, String imageUrl) {
		super();
		this.id = id;
		this.idPodium = idPodium;
		this.idPodiumItem = idPodiumItem;
		this.name = name;
		this.numberOfVotes = numberOfVotes;
		this.nameItem = nameItem;
		this.points = points;
		this.imageUrl = imageUrl;
	}

	/**
	 * @param id
	 * @param idPodium
	 * @param idPodiumItem
	 * @param name
	 * @param numberOfVotes
	 * @param nameItem
	 * @param points
	 * @param imageUrl
	 */
	public PodiumDAO(Integer idPodium, Integer idPodiumItem, String name, Integer numberOfVotes,
			String nameItem, int points, String imageUrl) {
		super();
		this.idPodium = idPodium;
		this.idPodiumItem = idPodiumItem;
		this.name = name;
		this.numberOfVotes = numberOfVotes;
		this.nameItem = nameItem;
		this.points = points;
		this.imageUrl = imageUrl;
	}

	/**
	 * @param podium
	 * @param id
	 * @param podiumId
	 * @param idPodiumItem
	 */
	public PodiumDAO(Podium podium, Integer id, Integer idPodiumItem) {
		super();
		this.id = id;
		this.idPodium = podium.getId();
		this.idPodiumItem = idPodiumItem;
		if(podium.getName() == null){podium.setName("");}
		this.name = podium.getName();
		if(podium.getNumberOfVotes() == null){podium.setNumberOfVotes(0);}
		this.numberOfVotes = podium.getNumberOfVotes();
		if(podium.getItems().get(idPodiumItem).getName() == null){podium.getItems().get(idPodiumItem).setName("");}
		this.nameItem = podium.getItems().get(idPodiumItem).getName();
		if(podium.getItems().get(idPodiumItem).getPoints() == null){podium.getItems().get(idPodiumItem).setPoints(0);}
		this.points = podium.getItems().get(idPodiumItem).getPoints();
		if(podium.getItems().get(idPodiumItem).getImageUrl() == null){podium.getItems().get(idPodiumItem).setImageUrl("");}
		this.imageUrl = podium.getItems().get(idPodiumItem).getImageUrl();
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	/** Id */
	@Column(name ="id")
	private Integer id;

	@Column(name ="idPodium")
	/** idPodium */
	private Integer idPodium;

	@Column(name ="idPodiumItem")
	/** idPodiumItem */
	private Integer idPodiumItem;

	@Column(name ="name")
	/** Name */
	private String name;

	@Column(name ="numberOfVotes")
	/** NumberOfVotes */
	private Integer numberOfVotes;
	
	@Column(name ="nameItem")
	/** Name */
	private String nameItem;

	@Column(name ="points")
	/** Points */
	private int points;

	@Column(name ="imageUrl")
	/** ImageUrl */
	private String imageUrl;

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
	 * @return the idPodiumItem
	 */
	public Integer getIdPodiumItem() {
		return idPodiumItem;
	}

	/**
	 * @param idPodiumItem the idPodiumItem to set
	 */
	public void setIdPodiumItem(Integer idPodiumItem) {
		this.idPodiumItem = idPodiumItem;
	}

	/**
	 * @return the nameItem
	 */
	public String getNameItem() {
		return nameItem;
	}

	/**
	 * @param nameItem the nameItem to set
	 */
	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
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

	/**
	 * @return the idPodium
	 */
	public Integer getIdPodium() {
		return idPodium;
	}

	/**
	 * @param idPodium the idPodium to set
	 */
	public void setIdPodium(Integer idPodium) {
		this.idPodium = idPodium;
	}
}