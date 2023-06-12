package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist,Integer> {

//    @Query("SELECT a FROM Artist a INNER JOIN a.genre g WHERE g.name = :genre")
//    List<Artist>getArtistsByGenreName(@Param("genre")String genre);
}
