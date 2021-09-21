package com.example.offerdaysongs.service;

import com.example.offerdaysongs.model.Recording;
import com.example.offerdaysongs.repository.RecordingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordingService {
    private final RecordingRepository recordingRepository;

    public RecordingService(RecordingRepository recordingRepository) {
        this.recordingRepository = recordingRepository;
    }

    public List<Recording> getAll() {
        return recordingRepository.findAll();
    }
}
