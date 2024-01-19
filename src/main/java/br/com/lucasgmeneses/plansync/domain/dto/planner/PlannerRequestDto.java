package br.com.lucasgmeneses.plansync.domain.dto.planner;

import br.com.lucasgmeneses.plansync.domain.dto.todo.TodoRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record PlannerRequestDto(
                                @NotBlank String title,
                                @NotNull Long month,
                                @NotNull Long year,
                                @NotNull String notes){
}
