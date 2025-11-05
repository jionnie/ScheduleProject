package com.example.schedule.service;

import com.example.schedule.dto.CreateCommentRequest;
import com.example.schedule.dto.CreateCommentResponse;
import com.example.schedule.entity.Comment;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.CommentRepository;
import com.example.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 댓글 등록, 조회, 수정, 삭제 기능을 담당하는 서비스 클래스
 * 비즈니스 로직을 처리한다.
 *
 * @author jiwon jung
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    /**
     * 새로운 댓글을 생성한다.
     *
     * @param scheduleId 일정 id
     * @param request 댓글 생성 요청 DTO
     * @return 생성된 댓글 응답 DTO
     */
    @Transactional
    public CreateCommentResponse save(Long scheduleId, CreateCommentRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당 일정이 존재하지 않습니다.")
        );

        Comment comment = new Comment(
                request.getName(),
                request.getPassword(),
                request.getContent(),
                schedule
        );

        // 객체 그래프의 일관성을 위해 둘 다 추가 (List<Comment> comments와 실제 DB)
        schedule.addComment(comment);
        commentRepository.save(comment);

        return new CreateCommentResponse(
                comment.getId(),
                comment.getName(),
                comment.getContent(),
                comment.getSchedule().getId(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }

}
