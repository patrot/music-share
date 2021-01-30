package com.galvanize.lynx.music.share.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="playlist")
@Data
public class PlayList {

    @Id
    private Long id;
    private String name;
}
