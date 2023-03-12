package com.spotify.demo.service.impl;

import com.spotify.demo.exception.UserException;
import com.spotify.demo.model.dto.PlaylistsDTO;
import com.spotify.demo.model.entity.Playlists;
import com.spotify.demo.repository.PlaylistRepository;
import com.spotify.demo.service.PlaylistService;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final ModelMapper modelMapper;
    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(ModelMapper modelMapper, PlaylistRepository playlistRepository) {
        this.modelMapper = modelMapper;
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<PlaylistsDTO> getPlaylists() {
        try {
            List<Playlists> playlistsEntities = playlistRepository.findAll();
            return playlistsEntities.stream()
                    .map(playlistEntity -> modelMapper.map(playlistEntity, PlaylistsDTO.class))
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public List<PlaylistsDTO> getPlaylistsByUserId(String userId) {
        try {
            List<Playlists> usersEntities = playlistRepository.getPlaylistsByUserId(Long.valueOf(userId));
            return usersEntities.stream()
                    .map(playlistEntity -> modelMapper.map(playlistEntity, PlaylistsDTO.class))
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}