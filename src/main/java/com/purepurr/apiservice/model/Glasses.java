package com.purepurr.apiservice.model;

import javax.persistence.*;

@Entity
@Table(name="glasses")
public class Glasses {

    public Glasses(String id) {
        this.id = id;
    }

    @Id
    String id;

    @Column
    boolean rooted;

    @Column
    int status_virtual;

    @Column
    int status_physical;

    @OneToOne
    User user;

    @OneToOne
    User manager;
}
