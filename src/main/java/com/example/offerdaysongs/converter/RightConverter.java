package com.example.offerdaysongs.converter;

import com.example.offerdaysongs.dto.CompanyDto;
import com.example.offerdaysongs.dto.RecordingDto;
import com.example.offerdaysongs.dto.RightDto;
import com.example.offerdaysongs.dto.SingerDto;
import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.model.Recording;
import com.example.offerdaysongs.model.Right;
import org.springframework.stereotype.Component;

@Component
public class RightConverter {

    public RightDto convert(Right right) {
        RightDto dto = new RightDto();
        dto.setId(right.getId());
        dto.setStart(right.getStartTime());
        dto.setEnd(right.getEndTime());
        dto.setCompany(convertToDto(right.getCompany()));
        dto.setRecording(convertToDto(right.getRecording()));
        return dto;
    }

    private RecordingDto convertToDto(Recording recording) {
        var singer = recording.getSinger();
        return new RecordingDto(recording.getId(),
                recording.getTitle(),
                recording.getVersion(),
                recording.getReleaseTime(),
                singer != null ? new SingerDto(singer.getId(), singer.getName()) : null);
    }

    private CompanyDto convertToDto(Company company){
        return new CompanyDto(company.getId(), company.getName());
    }
}
