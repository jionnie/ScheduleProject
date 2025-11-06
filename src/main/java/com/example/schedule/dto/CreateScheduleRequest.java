package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;

/**
 * 일정 생성 요청 DTO
 *
 * @author jiwon jung
 */
@Getter
public class CreateScheduleRequest {

    private String name;
    private String password;
    private String title;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;
}
