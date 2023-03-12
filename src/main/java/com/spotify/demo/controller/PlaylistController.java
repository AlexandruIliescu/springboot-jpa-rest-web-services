package com.spotify.demo.controller;

import com.spotify.demo.model.dto.PlaylistsDTO;
import com.spotify.demo.service.PlaylistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/api/playlists", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlaylistsDTO>> getPlaylists() {
        return ResponseEntity.ok(playlistService.getPlaylists());
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/api/playlists/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlaylistsDTO>> getUserPlaylists(@PathVariable String userId) {
        return ResponseEntity.ok(playlistService.getPlaylistsByUserId(userId));
    }
}