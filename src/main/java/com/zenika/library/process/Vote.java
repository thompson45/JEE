package com.zenika.library.process;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vote implements Serializable {

	public Vote() {
		super();
	}

	public Vote(Integer order) {
		super();
		this.order = order;
	}

	@Id
	/** Order */
	private Integer order;

	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
}
