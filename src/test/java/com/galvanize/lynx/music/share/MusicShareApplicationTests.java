package com.galvanize.lynx.music.share;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MusicShareApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	@DisplayName("Get All Playlists")
	public void testGetAll_Returns_Playlist() throws Exception {

		mockMvc.perform(get("/api/v1/musicshare/playlists"))
				.andExpect(status().isOk());

	}


}
