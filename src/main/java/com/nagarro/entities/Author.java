package com.nagarro.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author  implements Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authId;
	private String authName;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "author")
	List<Book> book;

	public Author(int authId, String authName, List<Book> book) {

		this.authId = authId;
		this.authName = authName;
	}

	public Author(int authId, String authName) {
		super();
		this.authId = authId;
		this.authName = authName;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	@Override
	public String toString() {
		return "Author [authId=" + authId + ", authName=" + authName + ", book=" + book + "]";
	}

}
