package com.purepurr.apiservice.model;

import javax.persistence.*;

@Entity
@Table(name="video")
public class Video extends BaseModel {

    public Video(String video_name, Integer packet_id) {
        this.video_name = video_name;
        this.packet_id = packet_id;
    }

    @Column(length=50)
    String video_name;

    @Column
    Integer packet_id;
}