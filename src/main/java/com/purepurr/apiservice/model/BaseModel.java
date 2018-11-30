package com.purepurr.apiservice.model;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.annotation.WhenCreated;
import io.ebean.annotation.WhenModified;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.Instant;
import java.util.List;

@MappedSuperclass
public abstract class BaseModel {

    @Id
    protected long id;

    @Version
    protected long version;

    @WhenCreated
    protected Instant createdOn;

    @WhenModified
    protected Instant modifiedOn;

    public void save() {
        EbeanServer server = Ebean.getDefaultServer();
        server.save(this);
    }

    public static <T> List<T> find(Class<T> c) {
        return Ebean.find(c).findList();
    }
}