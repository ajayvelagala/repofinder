/**
 * 
 */
package com.repofinder.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.repofinder.daoimpl.RepoFinderDaoImpl;
import com.repofinder.model.GitTopic;
import com.repofinder.model.TopicItems;
import com.repofinder.model.UserForm;
import com.repofinder.model.UserSearch;
import com.repofinder.service.RepoService;

@Controller
public class RepoController {

	@Autowired
	RepoFinderDaoImpl repoFinderDao;
	
	@Autowired
	RepoService repoService;

	@GetMapping(value = { "/", "/login", "/logout" })
	public String getLoginForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/login")
	public String postLoginForm(@ModelAttribute("user") User user, Model model, HttpSession session) {
		System.out.println("in post login controller");
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		if ((user.getUsername().equals("user3") && user.getPassword().equals("user3"))
				|| (user.getUsername().equals("user1") && user.getPassword().equals("user1")) 
				||  (user.getUsername().equals("user2") && user.getPassword().equals("user2"))) {
			session.setAttribute("username", user.getUsername());
			return "redirect:/indexForm";

		} else if (user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
			session.setAttribute("username", user.getUsername());
			List<UserSearch> userSearch = repoService.findAll();
			model.addAttribute("userSearch", userSearch);

			return "admin";
		} else {
			return "login";

		}
	}
	@GetMapping("/indexForm")
	public String getIndexPage(Map<String, Object> model) {
		UserForm userForm = new UserForm();
		model.put("userForm", userForm);
		return "index";

	}

	@PostMapping("/find")
	public String getformPage(@ModelAttribute("userForm") UserForm userForm, Model model, HttpSession session)
			throws InterruptedException {

		List<TopicItems> list = new ArrayList<TopicItems>();
		GitTopic gitTopic = null;
		String url = "";	
		RestTemplate restTemplate = new RestTemplate();
		if (!StringUtils.isBlank(userForm.getTopic())) {
			url = url + "topic:" + userForm.getTopic();
		}
		if (!StringUtils.isBlank(userForm.getLang()) && StringUtils.isBlank(userForm.getTopic())) {
			url = url + "language:" + userForm.getLang();
		}

		if (!StringUtils.isBlank(userForm.getLang()) && !StringUtils.isBlank(userForm.getTopic())) {
			url = url + "&language:" + userForm.getLang();
		}
		repoService.insertUser((String) session.getAttribute("username"), url);

		if (!StringUtils.isBlank(url)) {
			for (int i = 1; i <= 2; i++) {
				Thread.sleep(1000);
				String pageUrl = url + "&page=" + i;
				String totalUrl = "https://api.github.com/search/repositories?q=" + pageUrl;
				System.out.println("totalUrl:" + totalUrl);
				ResponseEntity<GitTopic> response = restTemplate.getForEntity(totalUrl, GitTopic.class);
				gitTopic = response.getBody();
				List<TopicItems> lti = gitTopic.getItems();
				for (TopicItems ti : lti) {
					list.add(ti);
				}

			}

		}
		gitTopic.setItems(list);
		model.addAttribute("list", gitTopic);
		return "index";

	}

	@PostMapping("/dataTableAction")
	public ResponseEntity<GitTopic> dataTableAction(@ModelAttribute("userForm") UserForm userForm, Model model,
			HttpSession session) throws InterruptedException {
		RestTemplate restTemplate = new RestTemplate();
		String totalUrl = "https://api.github.com/search/repositories?q=topic:ruby&page=2";
		System.out.println("totalUrl:" + totalUrl);
		ResponseEntity<GitTopic> response = restTemplate.getForEntity(totalUrl, GitTopic.class);
		GitTopic gitTopic = response.getBody();
		List<TopicItems> lti = gitTopic.getItems();
		System.out.println();
		return response;
	}

	@GetMapping("/adminFind")
	public String adminFind(HttpServletRequest request, Model model, HttpSession session) throws InterruptedException {
		List<TopicItems> list = new ArrayList<TopicItems>();
		GitTopic gitTopic = null;
		String result = request.getParameter("id");
		RestTemplate restTemplate = new RestTemplate();
		String url=  result;
		if (!StringUtils.isBlank(url)) {
			for (int i = 1; i <= 2; i++) {
				Thread.sleep(1000);
				String pageUrl = url + "&page=" + i;
				String totalUrl = "https://api.github.com/search/repositories?q=" + pageUrl;
				System.out.println("totalUrl:" + totalUrl);
				ResponseEntity<GitTopic> response = restTemplate.getForEntity(totalUrl, GitTopic.class);
				gitTopic = response.getBody();
				List<TopicItems> lti = gitTopic.getItems();
				for (TopicItems ti : lti) {
					list.add(ti);
				}

			}

		}
		gitTopic.setItems(list);
		model.addAttribute("list", gitTopic);
		UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);
		model.addAttribute("list", gitTopic);
		return "index";

	}

}
