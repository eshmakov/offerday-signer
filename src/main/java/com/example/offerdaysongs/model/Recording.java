package com.example.offerdaysongs.model;

import liquibase.pro.packaged.E;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
public class Recording {
    @Id
    long id;
    String title;
    String version;
    ZonedDateTime releaseTime;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    List<Singer> singers;
}
