package com.spotify.demo.repository;

import com.spotify.demo.model.entity.Songs;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SongsRepository extends JpaRepository<Songs, Long> {

    @Query(value = "select AR.name as artist, AB.title as album, S.title as song\n"
            + "from artists as AR\n"
            + "left join albums as AB\n"
            + "on AR.id = AB.artist_id\n"
            + "left join songs as S\n"
            + "on AB.id = S.album_id where S.title ilike :title ", nativeQuery = true)
    List<Object[]> getSongsByTitle(@Param("title") String title);

    @Query(value = "select AR.name as artist, AB.title as album, S.title as song\n"
            + "from artists as AR\n"
            + "left join albums as AB\n"
            + "on AR.id = AB.artist_id\n"
            + "left join songs as S\n"
            + "on AB.id = S.album_id", nativeQuery = true)
    List<Object[]> getSongs();
}