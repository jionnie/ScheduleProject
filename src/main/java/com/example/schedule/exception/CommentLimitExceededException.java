package com.example.schedule.exception;

/**
 * 댓글 수가 10개가 넘어갔을 때 발생하는 예외 클래스
 *
 * @author jiwon jung
 */
public class CommentLimitExceededException extends RuntimeException {

    public CommentLimitExceededException() {
        super("댓글 수는 10개를 넘을 수 없습니다.");
    }
}
