package com.example.servingwebcontent.genre;

import com.example.servingwebcontent.artist.ArtistDTO;
import com.example.servingwebcontent.place.PlaceDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private GenreRepository genreRepository;
    private static final ModelMapper modelMapper=new ModelMapper();
@Autowired
    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }
    public int createGenre (NewGenreDTO newGenreDTO){
    Genre genre= modelMapper.map(newGenreDTO, Genre.class);
    return genreRepository.save(genre).getId();
    }
    public GenreDTO getGenre(int id){
    Genre genre = genreRepository.findById(id).get();
    GenreDTO result= modelMapper.map(genre,GenreDTO.class);
    return result;
    }

    public List<GenreDTO> getGenreByGenreName(String genre) {
    List<Genre>genres=genreRepository.findByGenre(genre);
    return  modelMapper.map(genres,new TypeToken<List<GenreDTO>>(){}.getType());

    }

    public List<ArtistDTO> getArtistsByGenreName(String genre) {
    List<Genre> genreNew = genreRepository.findByGenre(genre);
    return modelMapper.map(genreNew,new TypeToken<List<ArtistDTO>>(){}.getType());
    }
}
