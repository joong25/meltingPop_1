package com.meltingpop.melting_pop_1_server.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

// @Entity : 테이블과의 매핑
// @Entity가 붙은 클래스는 JPA.가 관리하는 것이다.
// @Table : 엔티티와 매핑할 테이블을 지정
// 생략시 매핑한 엔티티 이름을 테이블 이름으로 사용

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String author;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column
    private LocalDateTime modifiedDate;

    @Builder
    public BoardVO(Long idx, String author, String title, String content) {
        this.idx = idx;
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
