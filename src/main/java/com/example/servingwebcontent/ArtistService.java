package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    @Autowired
    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    static final List<ArtistDTO> ARTIST_DTOS = new ArrayList<ArtistDTO>() {{
        add(new ArtistDTO("Paolo Roberty", "drama"));
        add(new ArtistDTO("Ann Hayway", "musical"));
        add(new ArtistDTO("Jery Jim", "drama"));
        add(new ArtistDTO("Deny Makgregor", "comedy"));
    }};

    List<ArtistDTO> getArtists(String genreFilter) {

        Iterable<Artist> allArtists=artistRepository.findAll();
        List<ArtistDTO> result= new ArrayList<ArtistDTO>();
        for (Artist artist:allArtists) {
            ArtistDTO artistDTO=new ArtistDTO(artist.getName(),artist.getGenre());
            result.add(artistDTO);

        }
        return result;
//        List<ArtistDTO> result = ARTIST_DTOS;
//
//        if (!genreFilter.equals("all")) {
//            result = ARTIST_DTOS.stream().filter(e -> e.getGenre().equals(genreFilter)).collect(Collectors.toList());
//        }
//        return result;
    }

    public ArtistDTO getArtist(int id) {
        ArtistDTO artistDTO = ARTIST_DTOS.get(id);
        return artistDTO;
    }

    public ArtistDTO deleteArtist(int id) {
        ArtistDTO artistDTO = ARTIST_DTOS.get(id);
        return artistDTO;
    }
public ArtistDTO createArtist(ArtistDTO artistDTO){
        String name= artistDTO.getName();
        String genre=artistDTO.getGenre();
        Artist artist = new Artist();
        artist.setName(name);
        artist.setGenre(genre);
        artistRepository.save(artist);
        return  artistDTO;
}
    public ArtistDTO updateArtist(int id, ArtistDTO newArtistDTO) {
        ArtistDTO artistDTO = ARTIST_DTOS.get(id);
        artistDTO = newArtistDTO;
        return artistDTO;

    }
}
