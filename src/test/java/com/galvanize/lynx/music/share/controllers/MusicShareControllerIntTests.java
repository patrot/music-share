package com.galvanize.lynx.music.share.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.model.Song;
import com.galvanize.lynx.music.share.repository.MusicShareRepositoy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MusicShareControllerIntTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MusicShareRepositoy musicShareRepositoy;

    @Autowired
    ObjectMapper objectMapper;



    @Test
    public void createNewPlaylistWithoutName() throws Exception {
        mockMvc.perform(post("/api/v1/musicshare/playlist"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("Playlist name needed"));
    }


    @Test
    public void testAdd_Song_toPlaylist() throws Exception {
        PlayList playList = PlayList.builder()
                .name("pop")
                .build();

        musicShareRepositoy.save(playList);
        Song song = Song.builder().name("happy happy").build();
        mockMvc.perform(put("/api/v1/musicshare/pop/addsong")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(song)))
                .andExpect(status().isOk());
    }
}
