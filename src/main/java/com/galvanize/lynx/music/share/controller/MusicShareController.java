package com.galvanize.lynx.music.share.controller;

import com.galvanize.lynx.music.share.exceptions.ProvidePlaylistNameException;
import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.model.Song;
import com.galvanize.lynx.music.share.service.MusicShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    @ResponseStatus(HttpStatus.CREATED)
    public PlayList createNewPlaylist(@RequestBody PlayList playList) throws ProvidePlaylistNameException {
       return musicShareService.save(playList);

    }

    @PutMapping("/api/v1/musicshare/{playlistName}/addsong")
    public void addSongToPlaylist(@PathVariable String playlistName, @RequestBody Song song){
        musicShareService.addSongToPlaylist(playlistName,song);
    }

}
