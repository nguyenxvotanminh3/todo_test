package com.nguyenminh.todolist.repository;

import com.nguyenminh.todolist.model.ToDoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListRepository extends MongoRepository<ToDoList,String> {


}
