package com.nguyenminh.todolist.controller;

import com.nguyenminh.todolist.dto.ListDto;
import com.nguyenminh.todolist.dto.ListResponse;
import com.nguyenminh.todolist.service.ListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ListController {
    private ListService listService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createList(@RequestBody ListDto ListDto){
        listService.createdList(ListDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    //A give list of ProductResponse
    public List<ListResponse> getAllProducts(){
        return listService.getAllList();
    }
}
