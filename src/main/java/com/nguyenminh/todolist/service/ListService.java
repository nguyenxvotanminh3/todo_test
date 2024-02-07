package com.nguyenminh.todolist.service;

import com.nguyenminh.todolist.dto.ListDto;
import com.nguyenminh.todolist.dto.ListResponse;
import com.nguyenminh.todolist.model.ToDoList;
import com.nguyenminh.todolist.repository.ListRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ListService {
    private final ListRepository listRepository;
    public void createdList(ListDto listDto){
        ToDoList toDoList = ToDoList.builder()
                .description(listDto.getDescription())
                .build();
        listRepository.save(toDoList);


        log.info("List {} is save", toDoList.getId());
    }
    public List<ListResponse> getAllList() {
        // find all and put in products
        List<ToDoList> list = listRepository.findAll();


        return list.stream().map(this::mapToListResponse).toList();

    }

    private ListResponse mapToListResponse(ToDoList toDoList) {

        return ListResponse.builder()
                .id(toDoList.getId())
                .description(toDoList.getDescription())
                .build();
    }

}
