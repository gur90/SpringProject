package com.example.servingwebcontent.genre;

import com.example.servingwebcontent.artist.Artist;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String genre;
    @OneToMany(mappedBy = "genre")
    private List<Artist> artists;
    @ManyToMany(mappedBy = "genres")
    private List<Artist> artistsG;

}
