package com.spotify.demo.model.dto;

public class PlaylistsDTO {

    private Long id;
    private String name;

    public PlaylistsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}