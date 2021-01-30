package com.galvanize.lynx.music.share.controller;

import com.galvanize.lynx.music.share.exceptions.ProvidePlaylistNameException;
import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.service.MusicShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicShareController {

    @Autowired
    private MusicShareService musicShareService;

    @GetMapping("/api/v1/musicshare/playlists")
    public List<PlayList> getAllPlaylists(){
        return musicShareService.getAllPlayLists();
    }

    @PostMapping("/api/v1/musicshare/playlist")
    public void createNewPlaylist() throws ProvidePlaylistNameException {
        throw new ProvidePlaylistNameException();
    }

}
