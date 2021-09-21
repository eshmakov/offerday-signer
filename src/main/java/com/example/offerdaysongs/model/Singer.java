package com.example.offerdaysongs.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Singer {
    @Id
    long id;
    String name;
}
