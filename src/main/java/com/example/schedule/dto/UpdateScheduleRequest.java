package com.example.schedule.dto;

import lombok.Getter;

/**
 * 일정 수정 요청 DTO
 *
 * @author jiwon jung
 */
@Getter
public class UpdateScheduleRequest {

    private String name;
    private String title;
    private String password;
}
