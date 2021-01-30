package com.galvanize.lynx.music.share.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.repository.MusicShareRepositoy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MusicShareControllerIntTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private MusicShareRepositoy musicShareRepositoy;


    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createNewPlaylistWithoutName() throws Exception {
        PlayList playList = PlayList.builder()
                .build();

        mockMvc.perform(post("/api/v1/musicshare/playlist")
                .content(mapper.writeValueAsString(playList))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("Playlist name needed"));
    }

    @Test
    public void createNewPlaylistWithName() throws Exception {

        PlayList playList = PlayList.builder()
                .name("Classic 80")
                .build();

        mockMvc.perform(post("/api/v1/musicshare/playlist")
                .content(mapper.writeValueAsString(playList))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("Classic 80"));

        List<PlayList> playLists = musicShareRepositoy.findAll();
        assertEquals(1, playLists.size());
        assertEquals("Classic 80", playLists.get(0).getName());
    }
}
