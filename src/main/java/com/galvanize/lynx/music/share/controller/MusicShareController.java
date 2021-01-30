package com.galvanize.lynx.music.share.controller;

import com.galvanize.lynx.music.share.exceptions.ProvidePlaylistNameException;
import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.model.Song;
import com.galvanize.lynx.music.share.service.MusicShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/v1/musicshare/{playlistName}/addsong")
    public void addSongToPlaylist(@PathVariable String playlistName, @RequestBody Song song){
        musicShareService.addSongToPlaylist(playlistName,song);
    }

}
