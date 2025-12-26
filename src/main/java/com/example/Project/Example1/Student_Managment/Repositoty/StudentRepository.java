package com.example.Project.Example1.Student_Managment.Repositoty;

import com.example.Project.Example1.Student_Managment.Entity.StudentEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,String> {
    Optional<StudentEntity> findByEmail(String email);

    @Modifying
    @Query("UPDATE StudentEntity s SET s.password = :password WHERE s.email = :email")
    int updatePasswordByEmail(@Param("email") String email,
                              @Param("password") String password);
}
