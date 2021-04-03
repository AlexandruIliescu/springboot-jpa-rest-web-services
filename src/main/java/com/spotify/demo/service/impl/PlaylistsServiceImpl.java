package com.spotify.demo.service.impl;

import com.spotify.demo.exception.UserException;
import com.spotify.demo.model.dto.PlaylistsDTO;
import com.spotify.demo.model.entity.Playlists;
import com.spotify.demo.repository.PlaylistsRepository;
import com.spotify.demo.service.PlaylistsService;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PlaylistsServiceImpl implements PlaylistsService {

    private final ModelMapper modelMapper;
    private final PlaylistsRepository playlistsRepository;

    @Autowired
    public PlaylistsServiceImpl(ModelMapper modelMapper, PlaylistsRepository playlistsRepository) {
        this.modelMapper = modelMapper;
        this.playlistsRepository = playlistsRepository;
    }

    @Override
    public List<PlaylistsDTO> getPlaylists() {
        try {
            List<Playlists> playlistsEntities = playlistsRepository.findAll();
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
            List<Playlists> usersEntities = playlistsRepository.getPlaylistsByUserId(Long.valueOf(userId));
            return usersEntities.stream()
                    .map(playlistEntity -> modelMapper.map(playlistEntity, PlaylistsDTO.class))
                    .collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}