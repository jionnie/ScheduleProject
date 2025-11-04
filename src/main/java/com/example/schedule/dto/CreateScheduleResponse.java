package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {

    private final Long id;
    private final String name;
    private final String title;
    private final String content;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateScheduleResponse(Long id, String name, String title, String content, LocalDate startDate, LocalDate endDate, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
