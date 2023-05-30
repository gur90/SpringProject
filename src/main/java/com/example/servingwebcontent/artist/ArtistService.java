package com.example.servingwebcontent.artist;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {
    private ArtistRepository artistRepository;
private static final ModelMapper modelMapper=new ModelMapper();
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
        Optional<Artist> artistOptional=artistRepository.findById(id);
        Artist artist=artistOptional.get();
        ArtistDTO artistDTO= modelMapper.map(artist, ArtistDTO.class);
        return artistDTO;
    }

    public void deleteArtist(int id) {

        artistRepository.deleteById(id);
    }
public ArtistDTO createArtist(ArtistDTO artistDTO){
       Artist artist= modelMapper.map(artistDTO, Artist.class);
        artistRepository.save(artist);
        return  artistDTO;
}
    public void updateArtist(int id, ArtistDTO newArtistDTO) {
        Artist artist = artistRepository.findById(id).get();

       artist.setName(newArtistDTO.getName());
        artist.setGenre(newArtistDTO.getGenre());
       artistRepository.save(artist);

    }
}
