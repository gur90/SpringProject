package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.event.EventDTO;
import com.example.servingwebcontent.genre.Genre;
import com.example.servingwebcontent.genre.GenreRepository;
import jakarta.persistence.GeneratedValue;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;
    private GenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    List<ArtistDTO> getArtists(String genreFilter) {
        List<Artist> allArtists = artistRepository.findAll();
        List<ArtistDTO> result = modelMapper.map(allArtists, new TypeToken<List<ArtistDTO>>() {
        }.getType());
        return result;
    }

    public ArtistDTO getArtist(int id) {
        Optional<Artist> artistOptional = artistRepository.findById(id);
        Artist artist = artistOptional.get();
        ArtistDTO artistDTO = modelMapper.map(artist, ArtistDTO.class);
        return artistDTO;
    }

    public void deleteArtist(int id) {
        artistRepository.deleteById(id);
    }

    public int createArtist(NewArtistDTO newArtistDTO) {
        int genreId = newArtistDTO.getGenreId();
        Genre genre = genreRepository.findById(genreId).get();
        Artist artist = new Artist();
        artist.setName(newArtistDTO.getName());
        artist.setGenre(genre);
        return artistRepository.save(artist).getId();

    }

    public void updateArtist(int id, NewArtistDTO newArtistDTO) {
        Optional<Artist> artistOptional = artistRepository.findById(id);
        Artist artist = artistOptional.get();
        artist.setName(newArtistDTO.getName());
        Genre genre = genreRepository.findById(newArtistDTO.getGenreId()).get();
        artist.setGenre(genre);
        artistRepository.save(artist);
    }

    public List<ArtistDTO> getArtistsByGenre(int genreId) {
        Genre genre = genreRepository.findById(genreId).get();
        List<Artist> artistsForGenre = genre.getArtists();
        List<ArtistDTO> result = modelMapper.map(artistsForGenre, new TypeToken<List<ArtistDTO>>() {
        }.getType());
        return result;
    }
}
