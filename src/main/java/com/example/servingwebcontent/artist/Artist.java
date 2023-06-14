package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.event.Event;
import com.example.servingwebcontent.genre.Genre;
import com.example.servingwebcontent.place.Place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "artists")
public class Artist {
   // @GeneratedValue
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
   @NotNull
    private String name;
   @ManyToOne
   @NotNull
    private Genre genre;

  @OneToMany(mappedBy="artist")
   private List<Event> events;
    @ManyToMany
    @JoinTable(
            name = "event",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
  private List <Place>places;
    @ManyToMany
    @JoinTable(
            name = "genres",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List <Genre> genres;
}
