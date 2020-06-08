package com.repofinder.model;


public class UserSearch {
    private String id;
	private String name;
	private String search_result;
	private String created_date;
	
	
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSearch_result() {
		return search_result;
	}
	public void setSearch_result(String search_result) {
		this.search_result = search_result;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserSearch(String id, String name, String search_result, String created_date) {
		super();
		this.id = id;
		this.name = name;
		this.search_result = search_result;
		this.created_date = created_date;
	}
	

	
	
	
}
