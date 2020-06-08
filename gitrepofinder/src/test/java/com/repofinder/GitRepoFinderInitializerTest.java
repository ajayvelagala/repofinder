package com.repofinder;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static java.util.Arrays.asList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.repofinder.daoimpl.RepoFinderDaoImpl;
import com.repofinder.model.UserSearch;
import com.repofinder.serviceimpl.RepoServiceImpl;

public class GitRepoFinderInitializerTest {

	@Mock
	private RepoFinderDaoImpl repoFinderDao;
	
	@InjectMocks
	private RepoServiceImpl repoService;

	@Captor
	private ArgumentCaptor<String> idCaptor;

	@Captor
	private ArgumentCaptor<Double> amountCaptor;

	
	
	//private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRepoForZeroList() {
		when(repoFinderDao.findAllByString())
			.thenReturn(emptyList());
		assertThat(repoService.findAll()).isEmpty();
	}
	
	@Test
	public void testRepoWithListCheckUser() {
		when(repoFinderDao.findAllByString())
			.thenReturn(asList(new UserSearch(null,"user", null)));
		List<UserSearch> lu=repoService.findAll();
		assertThat(lu.get(0).getName()).isEqualTo("user");
	}
	
	@Test
	public void testRepoWithListIdAndResult() {
		when(repoFinderDao.findAllByString())
			.thenReturn(asList(new UserSearch("2",null, "c++")));
		List<UserSearch> lu=repoService.findAll();
		assertThat(lu.get(0).getId()).isEqualTo("2");
		
	}

	@Test
	public void testRepoWith() {
		when(repoFinderDao.findAllByString())
			.thenReturn(asList(new UserSearch(null,null, "c++")));
		List<UserSearch> lu=repoService.findAll();
		
		assertThat(lu.get(0).getSearch_result()).isEqualTo("c++");
	}

	

}
