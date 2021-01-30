package com.galvanize.lynx.music.share.service;

import com.galvanize.lynx.music.share.exceptions.ProvidePlaylistNameException;
import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.repository.MusicShareRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicShareService {

    @Autowired
    private MusicShareRepositoy musicShareRepositoy;

    public List<PlayList> getAllPlayLists() {
       return musicShareRepositoy.findAll();
    }

    public PlayList save(PlayList playList) throws ProvidePlaylistNameException {
        if(playList.getName() == null || playList.getName().isEmpty()){
            throw new ProvidePlaylistNameException();
        }
           return musicShareRepositoy.save(playList);
    }
}
