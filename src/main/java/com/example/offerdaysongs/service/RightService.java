package com.example.offerdaysongs.service;

import com.example.offerdaysongs.dto.requests.CreateRightRequest;
import com.example.offerdaysongs.model.Company;
import com.example.offerdaysongs.model.Recording;
import com.example.offerdaysongs.model.Right;
import com.example.offerdaysongs.repository.CompanyRepository;
import com.example.offerdaysongs.repository.RecordingRepository;
import com.example.offerdaysongs.repository.RightRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RightService {
    private final RightRepository rightRepository;
    private final CompanyRepository companyRepository;
    private final RecordingRepository recordingRepository;

    public RightService(RightRepository rightRepository,
                        CompanyRepository companyRepository,
                        RecordingRepository recordingRepository) {
        this.rightRepository = rightRepository;
        this.companyRepository = companyRepository;
        this.recordingRepository = recordingRepository;
    }

    public List<Right> getAll() {
        return rightRepository.findAll();
    }

    public Right getById(long id) {
        return rightRepository.getById(id);
    }

    public List<Right> getByRecording(long recordingId) {
        return rightRepository.findByRecording_Id(recordingId);
    }

    public List<Right> getByCompany(long companyId) {
        return rightRepository.findByCompany_Id(companyId);
    }

    @Transactional
    public Right create(CreateRightRequest request) {
        Right right = new Right();
        right.setStartTime(request.getStartTime());
        right.setEndTime(request.getEndTime());

        Company company = companyRepository.getById(request.getCompanyId());
        if (company != null)
        {
            right.setCompany(company);
        }

        Recording recording = recordingRepository.getById(request.getRecordingId());
        if (recording != null)
        {
            right.setRecording(recording);
        }
        rightRepository.save(right);
        return right;
    }
}
