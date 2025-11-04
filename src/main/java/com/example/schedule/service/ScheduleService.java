package com.example.schedule.service;

import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 일정 등록, 조회, 수정, 삭제 기능을 담당하는 서비스 클래스
 * 비즈니스 로직을 처리한다.
 *
 * @author jiwon jung
 */
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    /**
     * 새로운 일정을 생성한다.
     *
     * @param request 일정 생성 요청 DTO
     * @return 생성된 일정 응답 DTO
     */
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
