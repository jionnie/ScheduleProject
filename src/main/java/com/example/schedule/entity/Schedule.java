package com.example.schedule.entity;

import com.example.schedule.exception.CommentLimitExceededException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 일정 정보를 저장하는 엔티티
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
    private Long id;                // 고유 식별자 id
    
    @Column(nullable = false)
    private String name;            // 작성자 이름
    
    @Column(nullable = false)
    private String password;        // 비밀번호
    
    @Column(nullable = false)
    private String title;           // 일정 제목
    
    private String content;         // 일정 내용
    
    @Column(nullable = false, name = "start_date")
    private LocalDate startDate;    // 일정 시작일
    
    @Column(nullable = false, name = "end_date")
    private LocalDate endDate;      // 일정 마감일

    @OneToMany(mappedBy = "schedule", fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();

    public Schedule(String name, String password, String title, String content, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.password = password;
        this.title = title;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void update(String name, String title) {
        if (name != null)
            this.name = name;
        if (title != null)
            this.title = title;
    }

    public void addComment(Comment comment) {
        if (comments.size() >= 10) {
            throw new CommentLimitExceededException();
        }

        comments.add(comment);
    }
}
