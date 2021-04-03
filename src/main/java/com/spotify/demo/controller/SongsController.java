package com.spotify.demo.controller;

import com.spotify.demo.model.dto.SongsDetailsDTO;
import com.spotify.demo.service.SongsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongsController {

    private final SongsService songsService;

    @Autowired
    public SongsController(SongsService songsService) {
        this.songsService = songsService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/api/songs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SongsDetailsDTO>> getSongsByTitle(@RequestParam String title) {
        return ResponseEntity.ok(songsService.getSongsByTitle(title));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/api/songs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SongsDetailsDTO>> getSongs() {
        return ResponseEntity.ok(songsService.getSongs());
    }
}