package com.nguyenminh.todolist.service;

import com.nguyenminh.todolist.dto.ListDto;
import com.nguyenminh.todolist.dto.ListResponse;
import com.nguyenminh.todolist.model.ToDoList;
import com.nguyenminh.todolist.repository.ListRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ListService {
    private final ListRepository listRepository;
    public void createdList(ListDto listDto){
        ToDoList toDoList = ToDoList.builder()
                .description(listDto.getDescription())
                .isChecked(listDto.isChecked())
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
                .isChecked(toDoList.isChecked())
                .build();
    }


    public void deleteDescription(Long theId) {

    }

    public Optional<ToDoList> isChecked(String theId , Integer theValue) {
        // check if the id is represented
        Optional<ToDoList> checked = listRepository.findById(theId);

        // if present, modify and save
        checked.ifPresent(toDoList -> {
            if(theValue == 1 ){
            toDoList.setChecked(true);}
            if(theValue == 0){
                toDoList.setChecked(false);
            }
            listRepository.save(toDoList);
        });
        // if not present, throw exception
        if (checked.isEmpty()) {
            throw new RuntimeException("No ToDoList found with the given ID: " + theId);
        }

        return checked;

    }

    public Optional<ToDoList> findDesById(String theId) {
        Optional<ToDoList> toDoList = listRepository.findById(theId);

        if(toDoList.isPresent()){
           return toDoList;
        } else  {
            throw new RuntimeException("No description found");
        }
    }

    public void updateDesById(String theId, String theDes) {
        Optional<ToDoList> toDoList1 = listRepository.findById(theId);
        toDoList1.ifPresent(toDoList -> {
            toDoList.setChecked(false);
            toDoList.setDescription(theDes);
            listRepository.save(toDoList);
        });



    }

    public String deleteDesById(String theId) {
        Optional<ToDoList> toDoList = listRepository.findById(theId);
        if(toDoList.isPresent()) {
            listRepository.deleteById(theId);
            return "The note is deleted";
        }
        return  "No note is found";

    }



}
