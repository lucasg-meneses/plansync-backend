package br.com.lucasgmeneses.plansync.controller;


import br.com.lucasgmeneses.plansync.domain.dto.planner.PlannerResponseDto;
import br.com.lucasgmeneses.plansync.domain.dto.todo.TodoRequestDto;
import br.com.lucasgmeneses.plansync.domain.dto.todo.TodoResponseDto;
import br.com.lucasgmeneses.plansync.domain.model.TodoModel;
import br.com.lucasgmeneses.plansync.domain.model.UserModel;
import br.com.lucasgmeneses.plansync.repository.PlannerRepository;
import br.com.lucasgmeneses.plansync.repository.TodoRepository;
import br.com.lucasgmeneses.plansync.util.UtilConverter;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private PlannerRepository plannerRepository;

    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAllTodos(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(todoRepository.findAllByOwner(userDetails).stream().map(TodoResponseDto::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTodoById(@PathVariable String id){
        Optional<TodoModel> todoModel = todoRepository.findById(id);
        if (!todoModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No item found with this id");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new TodoResponseDto(todoModel.get()));
    }
    @PostMapping
    public ResponseEntity<TodoResponseDto> saveTodo(@AuthenticationPrincipal UserDetails userDetails, @RequestBody @Valid TodoRequestDto todoRequestDto){
        var todoModel = new TodoModel();

        BeanUtils.copyProperties(todoRequestDto, todoModel);
        todoModel.setStartTime(UtilConverter.converterStringToLocalTime(todoRequestDto.startTime()));
        todoModel.setEndTime(UtilConverter.converterStringToLocalTime(todoRequestDto.endTime()));
        todoModel.setOwner((UserModel) userDetails);
        Date dateNow = new Date();
        todoModel.setPlanner(plannerRepository.findById(todoRequestDto.idPlanner()).get());
        todoModel.setDateCreated(dateNow);
        todoModel.setDateUpdated(dateNow);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TodoResponseDto(todoRepository.save(todoModel)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@RequestBody @Valid TodoRequestDto todoRequestDto, @PathVariable String id) {
        Optional<TodoModel> todoModel = todoRepository.findById(id);

        todoModel.map(todo -> {
            todo.setTitle(todoRequestDto.title());
            todo.setDescription(todoRequestDto.description());
            todo.setWeekday(todoRequestDto.weekday());
            todo.setStartTime(UtilConverter.converterStringToLocalTime(todoRequestDto.startTime()));
            todo.setEndTime(UtilConverter.converterStringToLocalTime(todoRequestDto.endTime()));
            todo.setDateUpdated(new Date());
            return todoRepository.save(todo);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new TodoResponseDto(todoModel.get()));
    }

    public ResponseEntity deleteTodo(@PathVariable String id){
        try {
            todoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("The item was successfully removed");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to remove item");
        }

    }
}
