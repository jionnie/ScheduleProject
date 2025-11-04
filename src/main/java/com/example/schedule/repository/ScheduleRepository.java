package com.example.schedule.repository;

import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Schedule 엔티티에 대한 CRUD 작업을 수행하는 JPA Repository 인터페이스
 *
 * @author jiwon jung
 */
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
