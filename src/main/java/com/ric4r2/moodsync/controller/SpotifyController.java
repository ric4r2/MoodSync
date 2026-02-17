package com.ric4r2.moodsync.controller;

import com.ric4r2.moodsync.service.SpotifyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spotify")
public class SpotifyController {

	private final SpotifyService spotifyService;

	public SpotifyController(SpotifyService spotifyService) {
		this.spotifyService = spotifyService;
	}

	@GetMapping("/callback")
	public String callback(@RequestParam String code) {
		return spotifyService.exchangeCode(code);
	}

  @GetMapping("/top-artists")
  public String getTopArtists() {
    return spotifyService.getTopArtists();
  }

}
