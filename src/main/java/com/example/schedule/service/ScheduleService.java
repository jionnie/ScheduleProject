package com.example.schedule.service;

import com.example.schedule.dto.*;
import com.example.schedule.entity.Schedule;
import com.example.schedule.exception.InvalidPasswordException;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
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

    /**
     * 일정의 고유 식별자(id)를 사용하여 선택한 일정 단건의 정보를 조회한다.
     * 
     * @param scheduleId 일정 고유 식별자
     * @return 조회된 일정 DTO
     */
    @Transactional
    public GetScheduleResponse findById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 일정입니다.")
        );

        return new GetScheduleResponse(
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

    /**
     * 등록된 일정 목록을 전부 조회한다.
     *
     * @return 조회된 전체 일정 목록 리스트
     */
    @Transactional
    public List<GetScheduleResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAllByOrderByModifiedAtDesc();

        List<GetScheduleResponse> dtos = schedules.stream()
                .map(schedule -> new GetScheduleResponse(
                        schedule.getId(),
                        schedule.getName(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getStartDate(),
                        schedule.getEndDate(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()))
                .toList();

        return dtos;
    }

    /**
     * 작성자 이름을 기준으로 등록된 일정 목록을 전부 조회한다.
     * 수정일 기준으로 내림차순 정렬한다.
     *
     * @param name 작성자 이름
     * @return 작성자 이름을 기준으로 조회된 일정 목록 리스트
     */
    @Transactional
    public List<GetScheduleResponse> findByName(String name) {
        List<Schedule> schedules = scheduleRepository.findByNameOrderByModifiedAtDesc(name);

        List<GetScheduleResponse> dtos = schedules.stream()
                .map(schedule -> new GetScheduleResponse(
                        schedule.getId(),
                        schedule.getName(),
                        schedule.getTitle(),
                        schedule.getContent(),
                        schedule.getStartDate(),
                        schedule.getEndDate(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()))
                .toList();

        return dtos;
    }

    /**
     * 선택한 일정 내용 중 일정 제목, 작성자명만 수정 가능하다.
     * 요청 시 비밀번호를 함께 전달한다.
     *
     * @param scheduleId 일정 고유 식별자
     * @param request 일정 수정 요청 DTO
     * @return 수정된 일정 DTO
     */
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 일정입니다.")
        );

        if (!request.getPassword().equals(schedule.getPassword())) {
             throw new InvalidPasswordException(); // 비밀번호 불일치 예외 터뜨림
        }

        schedule.update(
                request.getName(),
                request.getTitle()
        );

        return new UpdateScheduleResponse(
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

    /**
     * 선택한 일정을 삭제한다.
     *
     * @param scheduleId 일정 고유 식별자
     */
    @Transactional
    public void delete(Long scheduleId, DeleteScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 일정입니다.")
        );

        if (!request.getPassword().equals(schedule.getPassword())) {
            throw new InvalidPasswordException(); // 비밀번호 불일치 예외 터뜨림
        }

        scheduleRepository.delete(schedule);
    }
}
