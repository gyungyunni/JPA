package com.example.jpa.repos;

import com.example.jpa.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
// 하이버네이트를 더 편하게 사용하기 위한 라이브러리이다. 그대로 사용하는게 아닌 스프링의 기능
import java.util.List;

public interface StudentRepository // 데이터베이스와 소통하기 위한 창구
        // <내가 사용할 Entity, 그 Entity의 ID 컬럼의 타입>
        extends JpaRepository<StudentEntity, Long> {// 어떤 엔티티를 다뤄야 할지 알려줘야함

    // Spring Data JPA = Query Method
    // 메소드 이름을 우리가 조회하고 싶은 조건을 붙여서 만든다.
    // 하나 또는 많이
    // (findBy || findAllBy) + [(Column + 조건) * n] + [OrderBy + Column]
    // SELECT * FROM students ORDER BY name;
    List<StudentEntity> findAllByOrderByName();

    // SELECT * FROM students ORDER BY age DESC;
    List<StudentEntity> findAllByOrderByAgeDesc();

    // SELECT * FROM Students WHERE age < 21;
    List<StudentEntity> findAllByAgeLessThan(Integer age);

    // SELECT * FROM students WHERE phone LIKE '010-%'
    List<StudentEntity> findAllByPhoneStartingWith(String phone);
}