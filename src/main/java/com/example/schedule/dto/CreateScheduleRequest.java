package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateScheduleRequest {

    private String name;
    private String password;
    private String title;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;
}
