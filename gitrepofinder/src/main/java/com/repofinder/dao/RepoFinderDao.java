package com.repofinder.dao;

import java.util.List;

import com.repofinder.model.UserSearch;

public interface RepoFinderDao {
	
	public void insertUserInfo(String username,String searchResult);
	public List<UserSearch> findAllByString();

}
