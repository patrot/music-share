package com.galvanize.lynx.music.share.controller;

import com.galvanize.lynx.music.share.exceptions.ProvidePlaylistNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicShareController {

    @GetMapping("/api/v1/musicshare/playlists")
    public void getAllPlaylists(){


    }

    @PostMapping("/api/v1/musicshare/playlist")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void createNewPlaylist() throws ProvidePlaylistNameException {
        throw new ProvidePlaylistNameException();
    }

}
