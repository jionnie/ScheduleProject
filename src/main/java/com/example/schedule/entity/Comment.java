package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 댓글 정보를 저장하는 엔티티
 * 고유 id, 작성자명, 비밀번호, 내용 등의 필드를 포함한다.
 *
 * @author jiwon jung
 */
@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 고유 id

    @Column(nullable = false)
    private String name;            // 댓글 작성자 이름

    @Column(nullable = false)
    private String password;        // 비밀번호

    private String content;         // 댓글 내용

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;      // 댓글이 속하는 일정

    public Comment(String name, String password, String content, Schedule schedule) {
        this.name = name;
        this.password = password;
        this.content = content;
        this.schedule = schedule;
    }

}
