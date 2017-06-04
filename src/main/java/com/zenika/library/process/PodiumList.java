package com.zenika.library.process;

import java.util.ArrayList;
import java.util.List;

public class PodiumList {

	/**
	 * Podiums
	 */
	private List<Podium> podiums;

	/**
	 * 
	 */
	public PodiumList() {
		super();
		this.podiums = new ArrayList<Podium>();
	}
	
	/**
	 * @param Podium
	 */
	public void addPodium(Podium podium)
	{
		this.podiums.add(podium);
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
