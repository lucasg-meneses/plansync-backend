package br.com.lucasgmeneses.plansync.controller;

import br.com.lucasgmeneses.plansync.domain.dto.planner.PlannerRequestDto;
import br.com.lucasgmeneses.plansync.domain.dto.planner.PlannerResponseDto;
import br.com.lucasgmeneses.plansync.domain.dto.todo.TodoResponseDto;
import br.com.lucasgmeneses.plansync.domain.model.PlannerModel;
import br.com.lucasgmeneses.plansync.repository.PlannerRepository;
import br.com.lucasgmeneses.plansync.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planner")
public class PlannerController {
    @Autowired
    private PlannerRepository plannerRepository;
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<List<PlannerResponseDto>> getAllPlanners(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(plannerRepository.findAllByOwner(userDetails).stream().map(PlannerResponseDto::new).toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity getPlannerById(@PathVariable String id) {
        Optional<PlannerModel> plannerModel = plannerRepository.findById(id);
        if (!plannerModel.isPresent())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No item found with this id");

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new PlannerResponseDto(plannerModel.get()));

    }

    @PostMapping
    public ResponseEntity<PlannerResponseDto> savePlanner(@RequestBody @Valid PlannerRequestDto plannerDto) {
        PlannerModel plannerModel = new PlannerModel();
        BeanUtils.copyProperties(plannerDto, plannerModel);
        Date dateNow = new Date();
        plannerModel.setDateCreated(dateNow);
        plannerModel.setDateUpdated(dateNow);

        return ResponseEntity.status(HttpStatus.CREATED).body(new PlannerResponseDto(plannerRepository.save(plannerModel)));

    }

    @PutMapping("/{id}")
    public ResponseEntity<PlannerResponseDto> updatePlanner(@RequestBody @Valid PlannerRequestDto plannerRequestDto, @PathVariable String id) {
        Optional<PlannerModel> plannerModel = plannerRepository.findById(id);

        Optional<PlannerModel> plannnerModelUpdated = plannerModel.map(planner -> {
            planner.setTitle(plannerRequestDto.title());
            planner.setMonth(plannerRequestDto.month());
            planner.setYear(plannerRequestDto.year());
            planner.setNotes(plannerRequestDto.notes());
            planner.setDateUpdated(new Date());
            return plannerRepository.save(planner);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new PlannerResponseDto(plannnerModelUpdated.get()));
    }
    public ResponseEntity deletePlanner(@PathVariable String id){
        try {
            plannerRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("The item was successfully removed");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to remove item");
        }

    }
}
