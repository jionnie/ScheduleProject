package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 조회한 댓글 응답 DTO
 *
 * @author jiwon jung
 */
@Getter
public class GetCommentResponse {

    private final Long id;
    private final String name;
    private final String content;
    private final Long schedule_id;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetCommentResponse(Long id, String name, String content, Long scheduleId, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.schedule_id = scheduleId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
