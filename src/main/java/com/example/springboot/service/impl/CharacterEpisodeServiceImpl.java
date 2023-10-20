package com.example.springboot.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.exception.CharacterNotFoundException;
import com.example.springboot.model.CharacterDto;
import com.example.springboot.model.CharacterEpisode;
import com.example.springboot.model.Episode;
import com.example.springboot.service.CharacterEpisodeService;

@Service
public class CharacterEpisodeServiceImpl implements CharacterEpisodeService {

	Logger logger = LoggerFactory.getLogger(CharacterEpisodeServiceImpl.class);

	private final RestTemplate restTemplate;
	private final ExecutorService executorService = Executors.newCachedThreadPool();
	SimpleDateFormat sdfOrig = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	SimpleDateFormat sdfDest = new SimpleDateFormat("yyyy-MM-dd");
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

			var episodeNames = fetchUrls(characterEpisode.getResults().get(0).getEpisode());

			List<String> listNames = episodeNames.stream()
					.map(ep -> {
						try {
							return ep.get().getBody().getName();
						} catch (InterruptedException | ExecutionException e) {
							return "Error, Url no válida: " + e.getMessage();
						}
					})
					.collect(Collectors.toList());

			characterDto.setEpisodes(listNames);
			characterDto.setName(characterEpisode.getResults().get(0).getName());

			try {
				characterDto.setFirstAppearance(sdfDest.format(sdfOrig.parse(characterEpisode.getResults().get(0).getCreated())));
			} catch (ParseException e) {
				characterDto.setFirstAppearance("Error en la fecha");
			}
		}else{
			throw new CharacterNotFoundException("Character not found");
		}

		return characterDto;
	}

	public List<CompletableFuture<ResponseEntity<Episode>>> fetchUrls(List<String> urls) {
		return urls.stream()
				.map(url -> CompletableFuture.supplyAsync(() -> restTemplate.getForEntity(url, Episode.class), executorService))
				.collect(Collectors.toList());
	}

}
