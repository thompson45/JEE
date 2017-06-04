package com.zenika.library.process;

import java.util.List;

public class Vote {

	/**
	 * 
	 */
	public Vote() {
		super();
	}

	/**
	 * @param order
	 */
	public Vote(List<Integer> order) {
		super();
		this.setOrder(order);
	}

	/**
	 * @return the order
	 */
	public List<Integer> getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(List<Integer> order) {
		this.order = order;
	}

	private List<Integer> order;

}
