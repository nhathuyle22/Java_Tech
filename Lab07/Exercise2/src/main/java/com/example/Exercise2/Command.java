package com.example.Exercise2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Command {
    @Autowired
    StudentRepository studentRepository;
    @Bean
    public CommandLineRunner runner2(){return new CommandLineRunner() {
        @Override
        public void run(String... args) throws Exception {
            System.out.println("Add student: ");
            Student student1 = new Student(1L, "Hao", 14, "student1@gmail.com", 8.5);
            Student student2 = new Student(2L, "Tai", 18, "student2@gmail.com", 5.0);
            Student student3 = new Student(3L, "Tin", 21, "student3@gmail.com", 7.5);
            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
            print((List<Student>) studentRepository.findAll());

            System.out.println("Update student1: ");
            //Student studentRepository.findById(1L);
            student1.setName("hao");
            student1.setAge(20);
            student1.setScore(10);
            studentRepository.save(student1);
            print((List<Student>) studentRepository.findAll());

            System.out.println("Delete student2: ");
            studentRepository.deleteById(2L);
            print((List<Student>) studentRepository.findAll());
        }
    };
    }

    public void print(List<Student> students){
        for(Student i : students){
            System.out.println(i.toString());
        }
    }
}
