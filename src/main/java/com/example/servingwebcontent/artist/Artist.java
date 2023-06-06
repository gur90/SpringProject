package com.example.servingwebcontent.artist;

import com.example.servingwebcontent.genre.Genre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
