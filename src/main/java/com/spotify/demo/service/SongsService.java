package com.spotify.demo.service;

import com.spotify.demo.model.dto.SongsDetailsDTO;
import java.util.List;

public interface SongsService {

    List<SongsDetailsDTO> getSongsByTitle(String title);

    List<SongsDetailsDTO> getSongs();
}