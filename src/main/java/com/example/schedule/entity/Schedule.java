package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * 일정 정보를 저장하는 엔티티입니다.
 * 고유 id, 작성자 이름, 비밀번호, 일정 제목, 일정 내용 등의 필드를 포함한다.
 *
 * @author jiwon jung
 */
@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String title;
    private String content;
    @Column(nullable = false)
    private LocalDate startDate;
    @Column(nullable = false)
    private LocalDate endDate;

    public Schedule(String name, String password, String title, String content, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.password = password;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
