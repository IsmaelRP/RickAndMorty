package service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import exception.CharacterNotFoundException;
import model.CharacterEpisode;
import service.CharacterEpisodeService;

@Service
public class CharacterEpisodeServiceImpl implements CharacterEpisodeService {

	private final RestTemplate restTemplate;
    private final String apiUrl;
    
    
    public CharacterEpisodeServiceImpl(RestTemplate restTemplate, @Value("${rickandmortyapi.baseurl}") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }
    
	@Override
	public CharacterEpisode findCharacterEpisodeByName(String name) {		
		String fullUrl = apiUrl + "character?name=" + name;

        CharacterEpisode data = restTemplate.getForObject(fullUrl, CharacterEpisode.class);

        if (data == null) {
            throw new CharacterNotFoundException("Character not found");
        }

        return data;
	}

}
