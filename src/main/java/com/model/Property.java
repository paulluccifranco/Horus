package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Property")
public class Property {

	@Id
	private String name;
	@Column(name = "value", length = 255)
	private String value;

}
