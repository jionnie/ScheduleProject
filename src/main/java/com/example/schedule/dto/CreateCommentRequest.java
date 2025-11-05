package com.example.schedule.dto;

import lombok.Getter;

/**
 * 댓글 생성 DTO
 *
 * @author jiwon jung
 */
@Getter
public class CreateCommentRequest {

    private String name;
    private String password;
    private String content;
}
