package com.docker.controller;


import com.docker.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.docker.util.FakerUtil.*;


@RestController
public class MessageController {

  @GetMapping("/getMessage")
  public String getInitialMessage() {
    return "Application deployed successfully";
  }

  @GetMapping("/students")
  public List<Student> getStudentList(@RequestParam("count") long count) {
    List<Student> students = new CopyOnWriteArrayList<>();
    if (count == 0) {
      System.out.println("setting default value 10");
      count = 10;
    }
    CompletableFuture<Void> future = null;
    for (int i = 0; i < count; i++) {
       future =  CompletableFuture.runAsync(
              () -> {
                Student student = new Student(getId(), getName(), getAddress());
                students.add(student);
              });
      //Student student = new Student(getId(), getName(), getAddress());

    }
    future.join();
    System.out.println(students.size());
    return students;
  }
}
