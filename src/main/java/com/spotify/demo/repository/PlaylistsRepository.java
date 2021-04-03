package com.spotify.demo.repository;

import com.spotify.demo.model.entity.Playlists;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistsRepository extends JpaRepository<Playlists, Long> {

    @Query(value = "SELECT * FROM PLAYLISTS WHERE user_id =:id", nativeQuery = true)
    List<Playlists> getPlaylistsByUserId(@Param("id") Long id);
}