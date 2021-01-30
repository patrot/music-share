package com.galvanize.lynx.music.share.repository;

import com.galvanize.lynx.music.share.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository  extends JpaRepository<Song, Long> {
    public Song findByName(String name);
}
