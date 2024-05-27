package com.javatechie.crud.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_data")
class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String first_name;

	@Column(nullable = false)
	private String last_name;

	public String getFullName() {
		return first_name + " " + last_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(first_name, id, last_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person person = (Person) obj;
		return Objects.equals(first_name, person.first_name) && id == person.id
				&& Objects.equals(last_name, person.last_name);
	}

}
