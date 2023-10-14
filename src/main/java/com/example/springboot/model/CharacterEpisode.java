package com.example.springboot.model;

import java.io.Serializable;
import java.util.List;

public class CharacterEpisode implements Serializable {

	private static final long serialVersionUID = 8484645382186205730L;

	private Info info;
    private List<Character> results;
    
    
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	public List<Character> getResults() {
		return results;
	}
	public void setResults(List<Character> results) {
		this.results = results;
	}
    
    

}
