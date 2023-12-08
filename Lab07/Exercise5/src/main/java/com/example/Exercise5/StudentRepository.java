package com.example.Exercise5;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.age >=:x")
    public List<Student> findByAgeGreaterAndLess(@Param("x") int x);
    @Query("SELECT count(s) FROM Student s WHERE s.score =:x")
    public int countScore(@Param("x") double x);
    @Query("SELECT s FROM Student s WHERE s.name LIKE %:x%")
    public List<Student> findByNameContain(@Param("x") String xxx );
}
