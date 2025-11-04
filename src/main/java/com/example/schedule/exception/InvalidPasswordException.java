package com.example.schedule.exception;

/**
 * 비밀번호가 일치하지 않을 때 발생하는 예외 클래스
 *
 * @author jiwon jung
 */
public class InvalidPasswordException extends RuntimeException {

    public InvalidPasswordException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
