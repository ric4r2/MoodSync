package com.ric4r2.moodsync.config;

import org.springframework.beans.factory.annotation.value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

@Configuration
public class SpotifyConfig {

	@Value("${spotify.client.id}")
	private String clientId;

	@Value("${spotify.client.secrect}")
	private String clientSecret;

	@Value("${spotify.redirect.uri}")
	private String redirectUri;

	@Bean
	public SpotifyApi spotifyApi() {
		return new SpotifyApi.Builder()
			.setClientId(clientId)
			.setClientSecret(clientSecret)
			.setRedirectUri(SpotifyHttpManager.makeUri(redirectUri))
			.build();
	}
}
