package com.example.offerdaysongs.controller;

import com.example.offerdaysongs.converter.RightConverter;
import com.example.offerdaysongs.dto.RecordingDto;
import com.example.offerdaysongs.dto.RightDto;
import com.example.offerdaysongs.dto.SingerDto;
import com.example.offerdaysongs.dto.requests.CreateRightRequest;
import com.example.offerdaysongs.dto.requests.CreateSingerRequest;
import com.example.offerdaysongs.service.RightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rights")
public class RightController {
    private static final String ID = "id";
    private final RightService rightService;
    private final RightConverter rightConverter;

    public RightController(RightService rightService, RightConverter rightConverter) {
        this.rightService = rightService;
        this.rightConverter = rightConverter;
    }

    @GetMapping("/")
    public List<RightDto> getAll(){
        return rightService.getAll().stream()
                .map(r -> rightConverter.convert(r))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id:[\\d]+}")
    public RightDto get(@PathVariable(ID) long id) {
        var right = rightService.getById(id);
        return rightConverter.convert(right);
    }

    @PostMapping("/")
    public RightDto create(@RequestBody CreateRightRequest request) {
        return rightConverter.convert(rightService.create(request));
    }
}
