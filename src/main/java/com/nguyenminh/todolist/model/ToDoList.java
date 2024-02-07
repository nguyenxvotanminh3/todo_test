package com.nguyenminh.todolist.model;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Document(value = "list")
public class ToDoList {
    private String id;
    private String description;

}
