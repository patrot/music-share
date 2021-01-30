package com.galvanize.lynx.music.share.service;

import com.galvanize.lynx.music.share.exceptions.ProvidePlaylistNameException;
import com.galvanize.lynx.music.share.exceptions.SongNotFoundException;
import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.model.Song;
import com.galvanize.lynx.music.share.repository.MusicShareRepositoy;
import com.galvanize.lynx.music.share.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class MusicShareService {

    @Autowired
    private MusicShareRepositoy musicShareRepositoy;

    @Autowired
    private SongRepository songRepository;

    public List<PlayList> getAllPlayLists() {
        return musicShareRepositoy.findAll();
    }

    public PlayList addSongToPlaylist(String playlistName, Song song) throws SongNotFoundException {
        PlayList playList = musicShareRepositoy.findByName(playlistName);
        Set<Song> songSet = playList.getSongs();
        if(songSet == null ) {
            songSet = new HashSet<>();
        }
        if(songRepository.findByName(song.getName()) !=null) {
            songSet.add(song);
            playList.setSongs(songSet);
            return musicShareRepositoy.save(playList);
        }
        else{
            throw new SongNotFoundException();
        }

    }

    public PlayList save(PlayList playList) throws ProvidePlaylistNameException {
        if(playList.getName() == null || playList.getName().isEmpty()){
            throw new ProvidePlaylistNameException();
        }
           return musicShareRepositoy.save(playList);
    }

    public void removeSongFromPlaylist(String playlistName, Long songId) {
        PlayList playList = musicShareRepositoy.findByName(playlistName);
        Set<Song> songSet = playList.getSongs();
        Iterator<Song> songIterator = songSet.iterator();
        Song songForRemoval = null;
        while(songIterator.hasNext()) {
            Song song = songIterator.next();
            if (song.getId() == songId) {
                songForRemoval = song;
            }
        }

        songSet.remove(songForRemoval);

        musicShareRepositoy.save(playList);
    }
}
