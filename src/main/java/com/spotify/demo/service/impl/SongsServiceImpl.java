package com.spotify.demo.service.impl;

import com.spotify.demo.exception.UserException;
import com.spotify.demo.model.dto.SongsDetailsDTO;
import com.spotify.demo.repository.SongsRepository;
import com.spotify.demo.service.SongsService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SongsServiceImpl implements SongsService {

    private final ModelMapper modelMapper;
    private final SongsRepository songsRepository;

    @Autowired
    public SongsServiceImpl(ModelMapper modelMapper, SongsRepository songsRepository) {
        this.modelMapper = modelMapper;
        this.songsRepository = songsRepository;
    }

    @Override
    public List<SongsDetailsDTO> getSongsByTitle(String title) {
        try {
            List<SongsDetailsDTO> songs = new ArrayList<>();
            List<Object[]> songDetails = songsRepository.getSongsByTitle(title);
            songDetails.forEach(resultSet -> songs.add(mapObjectArrayToSongDetails(resultSet)));
            return songs;
        } catch (DataAccessException e) {
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public List<SongsDetailsDTO> getSongs() {
        try {
            List<SongsDetailsDTO> songs = new ArrayList<>();
            List<Object[]> songDetails = songsRepository.getSongs();
            songDetails.forEach(resultSet -> songs.add(mapObjectArrayToSongDetails(resultSet)));
            return songs;
        } catch (DataAccessException e) {
            throw new UserException("Error occurred", HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private SongsDetailsDTO mapObjectArrayToSongDetails(Object[] results) {
        SongsDetailsDTO songs = new SongsDetailsDTO();
        songs.setArtist((String) results[0]);
        songs.setAlbum((String) results[1]);
        songs.setSong((String) results[2]);
        return songs;
    }
}