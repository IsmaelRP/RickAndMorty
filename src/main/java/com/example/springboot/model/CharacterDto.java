package com.example.springboot.model;

import java.util.List;

public class CharacterDto {

	private String name;
    private List<String> episodes;
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
