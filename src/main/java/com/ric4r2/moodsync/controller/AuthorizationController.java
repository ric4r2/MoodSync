package com.ric4r2.moodsync.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;

@Controller
public class AuthorizationController {

    private final SpotifyApi spotifyApi;

    public AuthorizationController(SpotifyApi spotifyApi) {
        this.spotifyApi = spotifyApi;
    }

    @GetMapping("/login")
    public String login() {
        // Definimos los permisos que necesitamos (ver stats y crear playlists)
        AuthorizationCodeUriRequest request = spotifyApi.authorizationCodeUri()
                .scope("user-top-read,playlist-modify-public,playlist-modify-private")
                .show_dialog(true)
                .build();

        URI uri = request.execute();
        // Redirige al usuario a la página de autorización de Spotify
        return "redirect:" + uri.toString();
    }
}
