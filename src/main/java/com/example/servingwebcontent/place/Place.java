package com.example.servingwebcontent.place;

import com.example.servingwebcontent.artist.Artist;
import com.example.servingwebcontent.event.Event;
import javax.persistence.*;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @OneToMany(mappedBy = "place")
    private List<Event> events;

    @ManyToMany(mappedBy = "places")

    private List<Artist>artists;

}
