package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Schedule 엔티티에 대한 CRUD 작업을 수행하는 JPA Repository 인터페이스
 *
 * @author jiwon jung
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // Spring Data JPA는 메소드 이름을 분석해서 내부 로직(쿼리)를 자동으로 만들어줌
    List<Schedule> findByNameOrderByModifiedAtDesc(String name);
}
