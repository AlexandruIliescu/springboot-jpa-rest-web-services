package com.spotify.demo.service;

import com.spotify.demo.model.dto.PlaylistsDTO;
import java.util.List;

public interface PlaylistsService {

    List<PlaylistsDTO> getPlaylists();

    List<PlaylistsDTO> getPlaylistsByUserId(String userId);
}