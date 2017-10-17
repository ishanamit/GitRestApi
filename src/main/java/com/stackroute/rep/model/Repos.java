package com.stackroute.rep.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Table(name="REPOS")
public class Repos {
	@Id
	@GeneratedValue()
	private String id;
	public String getId() {
		return id;
	}
	public Repos(String id, String language, String username) {
		super();
		this.id = id;
		this.language = language;
		this.username = username;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String language;
	private String username;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Repos(String language, String username) {
		super();
		this.language = language;
		this.username = username;
	}
	public Repos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
    
}

