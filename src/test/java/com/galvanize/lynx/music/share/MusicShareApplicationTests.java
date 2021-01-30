package com.galvanize.lynx.music.share;

import com.galvanize.lynx.music.share.model.PlayList;
import com.galvanize.lynx.music.share.repository.MusicShareRepositoy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MusicShareApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MusicShareRepositoy musicShareRepositoy;


	@Test
	@DisplayName("Get All Playlists - Return Empty")
	public void testGetAll_Returns_Empty_Playlist() throws Exception {

		mockMvc.perform(get("/api/v1/musicshare/playlists"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(0)));
	}

	@Test
	@DisplayName("Get All Playlists - Return One PLayList")
	public void testGetAll_Returns_One_Playlist() throws Exception {

		PlayList playList = PlayList.builder()
							.name("Classic 80")
							.build();

		musicShareRepositoy.save(playList);
		mockMvc.perform(get("/api/v1/musicshare/playlists"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id").exists())
				.andExpect(jsonPath("$[0].name").value("Classic 80"));
	}
}
