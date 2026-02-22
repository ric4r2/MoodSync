package com.ric4r2.moodsync.service;

import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
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

  public String getTopArtists() {
    try {
      var request = spotifyApi.getUsersTopArtists()
              .limit(5)
              .build();
      var artists = request.execute();

      StringBuilder response = new StringBuilder("---- MoodSync: Your Top 5 Artists --- \n");
      for (var artist: artists.getItems()) {
        response.append(" - ").append(artist.getName()).append("\n");
      }
      return response.toString();
    } catch (Exception e) {
      return "Error while getting top artists: " + e.getMessage();
    }
  }
}
