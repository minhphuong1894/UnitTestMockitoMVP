package com.example.minhphuong.mock_unit.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by minhphuong on 1/24/18.
 */

public class CharacterModel {
    public final String name;
    public final String height;
    public final String mass;
    // "SerializedName" is a Gson annotation to remap the original JSON field into another custom name
    @SerializedName("hair_color")
    public final String hairColor;

    @SerializedName("skin_color")
    public final String skinColor;

    @SerializedName("eye_color")
    public final String eyeColor;

    @SerializedName("birth_year")
    public final String birthYear;

    public final String gender;
    public final String homeworld;
    public final List<String> films;
    public final List<String> species;
    public final List<String> vehicles;
    public final List<String> starships;
    public final String created;
    public final String edited;
    public final String url;

    public CharacterModel(String name, String height, String mass, String hairColor,
                          String skinColor, String eyeColor, String birthYear, String gender,
                          String homeworld, List<String> films, List<String> species, List<String> vehicles,
                          List<String> starships, String created, String edited, String url) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public List<String> getSpecies() {
        return species;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public List<String> getStarships() {
        return starships;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }
}
