package com.example.servingwebcontent.event;

import com.example.servingwebcontent.artist.Artist;
import com.example.servingwebcontent.place.Place;
import javax.persistence.*;
import com.sun.istack.NotNull;
//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @NotNull
    private String name;
    //    @NotNull
//    private String city;
    @ManyToOne
    @NotNull
    private Place place;
    @ManyToOne
    @JoinColumn(name = "artist_ref_id", referencedColumnName = "id")
    private Artist artist;

}
