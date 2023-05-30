package com.example.servingwebcontent.artist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Artist {
   // @GeneratedValue
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
   @NotNull
    private String name;
   @NotNull
    private String genre;
}
