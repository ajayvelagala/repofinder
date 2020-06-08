package com.repofinder.service;

import java.util.List;

import com.repofinder.model.UserSearch;

public interface RepoService {
	
	public void insertUser(String username, String url);
	public List<UserSearch> findAll();

}
