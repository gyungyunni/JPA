package com.example.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

/*
JPA와 Hibernate

JPA – Java Persistence API (Jakarta Persistence)
- 데이터가 어떻게 테이블에 매핑되는지 명세하기 위함
- 인터페이스와 어노테이션으로 구성

 */
@Data
@Entity
@Table(name="students") // 생성할 테이블 이름 지정
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 지정용도 테이블에는 무조건 pk가 필요하다.
    private Long id; // 참조형 작성 그 이유는?

    // Column 어노테이션에 인자를 전달해서 테이블 Constraint 추가 가능
    // @Column(name = "username", nullable = false, unique = true)
    private String name;
    private Integer age;
    // @Column(unique = true)
    private String phone;
    private String email;
}
/*
yaml
 */