package com.galvanize.lynx.music.share.service;

import com.galvanize.lynx.music.share.exceptions.ProvidePlaylistNameException;
import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.model.Song;
import com.galvanize.lynx.music.share.repository.MusicShareRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MusicShareService {

    @Autowired
    private MusicShareRepositoy musicShareRepositoy;

    public List<PlayList> getAllPlayLists() {
        return musicShareRepositoy.findAll();
    }

    public void addSongToPlaylist(String playlistName, Song song) {
        PlayList playList = musicShareRepositoy.findByName(playlistName);
        Set<Song> songSet = new HashSet<>();
        songSet.add(song);
        playList.setSongs(songSet);
        musicShareRepositoy.save(playList);
    }

    public PlayList save(PlayList playList) throws ProvidePlaylistNameException {
        if(playList.getName() == null || playList.getName().isEmpty()){
            throw new ProvidePlaylistNameException();
        }
           return musicShareRepositoy.save(playList);
    }
}
