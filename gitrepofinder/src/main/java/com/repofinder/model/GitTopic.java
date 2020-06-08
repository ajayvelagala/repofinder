package com.repofinder.model;

import java.util.List;

public class GitTopic {
	
	private String total_count;
	private String incomplete_results;
	private List<TopicItems> items;



	public String getTotal_count() {
		return total_count;
	}
	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}
	public String getIncomplete_results() {
		return incomplete_results;
	}
	public void setIncomplete_results(String incomplete_results) {
		this.incomplete_results = incomplete_results;
	}
	public List<TopicItems> getItems() {
		return items;
	}
	public void setItems(List<TopicItems> items) {
		this.items = items;
	}
	
	
	


}
