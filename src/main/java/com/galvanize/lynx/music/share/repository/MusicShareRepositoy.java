package com.galvanize.lynx.music.share.repository;

import com.galvanize.lynx.music.share.model.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicShareRepositoy extends JpaRepository<PlayList, Long> {
}
