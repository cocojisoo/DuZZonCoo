package com.example.DuZZonCoo.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Board {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column(length = 30)
    @NotBlank(message = "제목을 입력해주시긔")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 10)
    @NotBlank(message = "미 기재시, 익명(숫자)로 처리되긔")
    private String writer;

    @Column(length = 10)
    @NotBlank(message = "비밀번호를 입력해주시긔")
    private String password;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;


}