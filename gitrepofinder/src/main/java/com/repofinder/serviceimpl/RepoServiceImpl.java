package com.repofinder.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repofinder.daoimpl.RepoFinderDaoImpl;
import com.repofinder.model.UserSearch;
import com.repofinder.service.RepoService;

@Service(value="repoService")
public class RepoServiceImpl implements RepoService {
	
	@Autowired
	RepoFinderDaoImpl repoFinderDao;

	@Override
	public void insertUser(String username, String url) {
		
		repoFinderDao.insertUserInfo(username, url);
		
	}

	@Override
	public List<UserSearch> findAll() {
	
		return repoFinderDao.findAllByString();
	}

}
