package com.example.schedule.service;

import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getName(),
                request.getPassword(),
                request.getTitle(),
                request.getContent(),
                request.getStartDate(),
                request.getEndDate()
        );
        scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                schedule.getId(),
                schedule.getName(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getStartDate(),
                schedule.getEndDate(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }
}
