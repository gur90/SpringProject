package com.example.servingwebcontent.place;

import com.example.servingwebcontent.artist.Artist;
import com.example.servingwebcontent.artist.ArtistRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private PlaceRepository placeRepository;
    private ArtistRepository artistRepository;

    @Autowired

    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public void setPlaceRepository(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    public int createPlace(NewPlaceDTO newPlaceDTO) {
        Place place = modelMapper.map(newPlaceDTO, Place.class);
        return placeRepository.save(place).getId();
    }

    public PlaceDTO getPlace(int id) {
        Place place = placeRepository.findById(id).get();
        PlaceDTO result = modelMapper.map(place, PlaceDTO.class);
        return result;
    }
    public List<PlaceDTO>getPlaceByArtistId(int artistId){
Artist artist = artistRepository.findById(artistId).get();
        List<Place> placeForArtist =artist.getPlaces();
       return modelMapper.map(placeForArtist, new TypeToken<List<PlaceDTO>>(){}.getType());

    }
    public List<PlaceDTO> getPlaceByCityName(String city){
        List<Place>places=placeRepository.findByCity(city);
        return modelMapper.map(places,new TypeToken<List<PlaceDTO>>(){}.getType());

    }
    public List<PlaceDTO>getPlacesByCityWithAddress(String city, String address){
        List<Place>places = placeRepository.findByCityAndAddress(city,address);
        return modelMapper.map(places,new TypeToken<List<PlaceDTO>>(){}.getType());

    }
}
