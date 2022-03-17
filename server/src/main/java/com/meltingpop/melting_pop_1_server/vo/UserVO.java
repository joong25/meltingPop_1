package com.meltingpop.melting_pop_1_server.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


// @Data는 @Getter, @Setter, @RequiredArgsConstructor,
// @ToString, @EqualsAndHashCode 어노테이션을 한꺼번에
// 설정해주는 어노테이션이다.
@Entity
@Getter
@Setter
@Table
public class UserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserNum;

    @Column
    private String UserID;

    @Column
    private String UserPW;

    @Column
    private String UserEmail;
}
