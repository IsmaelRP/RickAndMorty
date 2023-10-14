package com.example.springboot.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.exception.CharacterNotFoundException;
import com.example.springboot.model.CharacterDto;
import com.example.springboot.model.CharacterEpisode;
import com.example.springboot.service.CharacterEpisodeService;

@Service
public class CharacterEpisodeServiceImpl implements CharacterEpisodeService {

	Logger logger = LoggerFactory.getLogger(CharacterEpisodeServiceImpl.class);
	
	private final RestTemplate restTemplate;
    private final String apiUrl;
    
    
    public CharacterEpisodeServiceImpl(RestTemplate restTemplate, @Value("${rickandmortyapi.baseurl}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }
    
	@Override
	public CharacterDto findCharacterEpisodeByName(String name) {		
		String fullUrl = apiUrl + "character/?name=" + name;
		CharacterDto characterDto = null;

        ResponseEntity<CharacterEpisode> data = restTemplate.getForEntity(fullUrl, CharacterEpisode.class);

        if(data.hasBody() && data.getStatusCode().is2xxSuccessful()) {
        	CharacterEpisode characterEpisode = data.getBody();
        	characterDto = new CharacterDto();
            characterDto.setName(characterEpisode.getResults().get(0).getName());
            characterDto.setEpisodes(characterEpisode.getResults().get(0).getEpisode());
            characterDto.setFirstAppearance(characterEpisode.getResults().get(0).getCreated());
        }else {
        	throw new CharacterNotFoundException("Character not found");
        }
        


        return characterDto;
	}

}
