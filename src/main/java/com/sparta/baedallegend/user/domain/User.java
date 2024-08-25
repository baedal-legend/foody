package com.sparta.baedallegend.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(
        name = "p_user",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_USER_EMAIL",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "UK_USER_NICKNAME",
                        columnNames = "nickname"
                )
        }
)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 45)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 45)
    private Role role;

    @Column(nullable = false, length = 200)
    private String password;

    // TODO : Auditor 사용을 위한 메타데이터 컬럼들이 구현되지 않았음
}