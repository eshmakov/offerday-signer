package com.example.offerdaysongs.dto;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class RightDto {
    long id;
    RecordingDto recording;
    CompanyDto company;
    ZonedDateTime start;
    ZonedDateTime end;
}
