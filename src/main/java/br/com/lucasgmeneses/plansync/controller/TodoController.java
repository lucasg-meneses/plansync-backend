package br.com.lucasgmeneses.plansync.controller;


import br.com.lucasgmeneses.plansync.domain.dto.todo.TodoRequestDto;
import br.com.lucasgmeneses.plansync.domain.model.TodoModel;
import br.com.lucasgmeneses.plansync.repository.PlannerRepository;
import br.com.lucasgmeneses.plansync.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private PlannerRepository plannerRepository;
    @PostMapping("/todos")
    public ResponseEntity<TodoModel> saveTodo(@RequestBody @Valid TodoRequestDto todoRequestDto){
        var todoModel = new TodoModel();
        BeanUtils.copyProperties(todoRequestDto, todoModel);
        Date dateNow = new Date();
        plannerRepository.findById(todoRequestDto.idPlanner());
        todoModel.setDateCreated(dateNow);
        todoModel.setDateUpdated(dateNow);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(todoModel));
    }
}
