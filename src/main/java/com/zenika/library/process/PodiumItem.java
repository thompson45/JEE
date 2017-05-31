package com.zenika.library.process;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class PodiumItem implements Serializable {

	@Transient
	private static final long serialVersionUID = -3437516655498989064L;

	public PodiumItem() {
		super();
	}

	public PodiumItem(String name, int points, String imageUrl, int idPodium) {
		super();
		this.name = name;
		this.points = points;
		this.imageUrl = imageUrl;
		this.idPodium = idPodium;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Podium")
	@Id
	@Column(name ="name")
	/** Name */
	private String name;

	@Column(name ="points")
	/** Points */
	private int points;

	@Column(name ="imageUrl")
	/** ImageUrl */
	private String imageUrl;

	@Column(name ="idPodium")
	/** IdPodium */
	private Integer idPodium;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getImageUrl() {
		return imageUrl;
	}

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
