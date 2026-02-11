package com.ric4r2.moodsync.service;

import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization_code.AuthorizationCodeRequest;
import java.io.IOException;
import org.apache.hc.core5.http.ParseException;

@Service
public class SpotifyService {

	private final SpotifyApi spotifyApi;

	public SpotifyService(SpotifyApi spotifyApi) {
		this.spotifyApi = spotifyApi;
	}


	public String exchangeCode(String code) {
		try {
			AuthorizationCodeRequest request = spotifyApi.authorizationCode(code).build();
			AuthorizationCodeCredentials credentials = request.execute();

			spotifyApi.setAccessToken(credentials.getAccessToken());
			spotifyApi.setRefreshToken(credentials.getRefreshToken());

			return credentials.getAccessToken();
		} catch (IOException | SpotifyWebApiException | ParseException e) {
			return "Error exchanging code: " + e.getMessage();
		}
	}
}
