package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 생성된 댓글 응답 DTO
 *
 * @author jiwon jung
 */
@Getter
public class CreateCommentResponse {

    private final Long id;
    private final String name;
    private final String content;
    private final Long schedule_id;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateCommentResponse(Long id, String name, String content, Long scheduleId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.schedule_id = scheduleId;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
