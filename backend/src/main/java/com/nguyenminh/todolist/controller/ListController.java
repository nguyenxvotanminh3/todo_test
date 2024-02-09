package com.nguyenminh.todolist.controller;

import com.nguyenminh.todolist.dto.ListDto;
import com.nguyenminh.todolist.dto.ListResponse;
import com.nguyenminh.todolist.model.ToDoList;
import com.nguyenminh.todolist.service.ListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/update/{theId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateList(@PathVariable String theId , @RequestBody String theDes){
        listService.updateDesById(theId, theDes);
        return null;
    }

    @PostMapping ("/checknote/{theId}/{theValue}")
    @ResponseStatus(HttpStatus.OK)
    //A give list of ProductResponse
    public Optional<ToDoList> isChecked(@PathVariable("theId") String theId , @PathVariable("theValue") int theValue){
       return listService.isChecked(theId,theValue);
    }

    @GetMapping("/{theId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ToDoList> getTheId(@PathVariable String theId){
       return listService.findDesById(theId);
    }



    @DeleteMapping("/delete/{theId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateList(@PathVariable String theId){
        return listService.deleteDesById(theId);
    }

}
