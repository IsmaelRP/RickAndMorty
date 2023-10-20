package com.example.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterDto {

	private String name;
    private List<String> episodes;
    
    @JsonProperty("first_appearance")
    private String firstAppearance;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getEpisodes() {
		return episodes;
	}
	public void setEpisodes(List<String> episodes) {
		this.episodes = episodes;
	}
	public String getFirstAppearance() {
		return firstAppearance;
	}
	public void setFirstAppearance(String firstAppearance) {
		this.firstAppearance = firstAppearance;
	}
    
    
}
