package com.spotify.demo.controller;

import com.spotify.demo.model.dto.SongsDetailsDTO;
import com.spotify.demo.service.SongService;
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
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/api/songs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SongsDetailsDTO>> getSongsByTitle(@RequestParam String title) {
        return ResponseEntity.ok(songService.getSongsByTitle(title));
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/api/songs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SongsDetailsDTO>> getSongs() {
        return ResponseEntity.ok(songService.getSongs());
    }
}