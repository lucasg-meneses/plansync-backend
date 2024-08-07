package br.com.lucasgmeneses.plansync.domain.dto.planner;

import br.com.lucasgmeneses.plansync.domain.dto.todo.TodoRequestDto;
import br.com.lucasgmeneses.plansync.domain.dto.todo.TodoResponseDto;
import br.com.lucasgmeneses.plansync.domain.model.PlannerModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record PlannerResponseDto(@NotBlank String id,
                                 @NotBlank String title,
                                 @NotNull Long month,
                                 @NotNull Long year,
                                 @NotNull String notes) {
    public PlannerResponseDto(PlannerModel plannerModel){
        this(plannerModel.getId(),
                plannerModel.getTitle(),
                plannerModel.getMonth(),
                plannerModel.getYear(),
                plannerModel.getNotes()
        );
    }

}
