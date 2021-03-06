package com.galvanize.lynx.music.share.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="playlist")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayList {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn( name = "so_fid", referencedColumnName = "id")
    private Set<Song> songs;

}
