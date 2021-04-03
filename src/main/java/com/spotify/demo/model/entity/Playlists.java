package com.spotify.demo.model.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Playlists {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Users user;

    @ManyToMany
    @JoinTable(
            name = "PLAYLISTS_SONGS",
            joinColumns = @JoinColumn(name = "PLAYLISTS_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SONGS_ID", referencedColumnName = "ID")
    )
    private List<Songs> songs;

    public Playlists() {
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }
}