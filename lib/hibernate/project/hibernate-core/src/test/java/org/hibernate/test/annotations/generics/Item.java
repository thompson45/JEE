/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */

//$Id$
package org.hibernate.test.annotations.generics;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author Emmanuel Bernard
 */
@MappedSuperclass
public class Item<Type, Owner> extends PricedStuff {
	private Integer id;
	private String name;
	private Type type;
	private Owner owner;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@ManyToOne
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
