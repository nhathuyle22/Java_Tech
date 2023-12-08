package com.example.Exercise4;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    public List<Student> findByAgeGreaterThanEqual(int x);
    public int countByScore(double x);
    public List<Student> findByNameContaining(String x);
}
