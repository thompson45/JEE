package com.zenika.library.process;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PodiumList implements Serializable {

	@Id
	/** Podiums */
	private List<Podium> podiums;

	public PodiumList(List<Podium> podiums) {
		super();
		this.podiums = podiums;
	}
	
	public PodiumList() {
		super();
	}
	
	/**
	 * @return the podiums
	 */
	public List<Podium> getPodiums() {
		return podiums;
	}

	/**
	 * @param podiums the podiums to set
	 */
	public void setPodiums(List<Podium> podiums) {
		this.podiums = podiums;
	}
}
