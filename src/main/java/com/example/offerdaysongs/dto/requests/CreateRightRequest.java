package com.example.offerdaysongs.dto.requests;

import com.example.offerdaysongs.dto.CompanyDto;
import com.example.offerdaysongs.dto.RecordingDto;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CreateRightRequest {
    private long recordingId;
    private long companyId;
    private ZonedDateTime startTime;
    private ZonedDateTime endTime;
}
