package com.sundarland.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sundarland.game.bean.Api;
import com.sundarland.game.bean.Game;
import com.sundarland.game.repository.APIRepository;
import com.sundarland.game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootApplication
public class GameApplication implements CommandLineRunner {
	@Value("classpath:game.json")
	private Resource resource;

	@Value("classpath:api.json")
	private Resource apiResource;

	private ObjectMapper objectMapper;
	private GameRepository gameRepository;
	private APIRepository apiRepository;

	public static void main(String[] args) {
		SpringApplication.run(GameApplication.class, args);
	}

	GameApplication(GameRepository gameRepository, APIRepository apiRepository){
		this.gameRepository = gameRepository;
		this.objectMapper = new ObjectMapper();
		this.apiRepository = apiRepository;
	}



	@Override
	public void run(String... strings) throws Exception {
		try {
			byte[] gameData = FileCopyUtils.copyToByteArray(resource.getInputStream());
			String gameItems = new String(gameData, StandardCharsets.UTF_8);
			List<Game> games = objectMapper.readValue(gameItems, new TypeReference<List<Game>>() {
			});

			byte[] apiData = FileCopyUtils.copyToByteArray(apiResource.getInputStream());
			String apiItems = new String(apiData, StandardCharsets.UTF_8);
			List<Api> apis = objectMapper.readValue(apiItems, new TypeReference<List<Api>>() {
			});

			gameRepository.saveAll(games);
			apiRepository.saveAll(apis);

		} catch (Exception se) {
			se.printStackTrace();
		}
	}
}

