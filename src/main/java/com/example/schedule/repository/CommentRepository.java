package com.example.schedule.repository;

import com.example.schedule.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Spring Data JPA는 메소드 이름을 분석해서 내부 로직(쿼리)를 자동으로 만들어줌
    Long countByScheduleId(Long scheduleId);
    List<Comment> findByScheduleId(Long scheduleId);
}
