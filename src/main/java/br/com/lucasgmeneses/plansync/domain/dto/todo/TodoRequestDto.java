package br.com.lucasgmeneses.plansync.domain.dto.todo;

import br.com.lucasgmeneses.plansync.domain.model.Weekday;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record TodoRequestDto(@NotBlank String title,
                             @NotBlank String description,
                             @NotBlank Weekday weekday,
                             @NotNull String idPlanner,
                             @NotBlank LocalTime startTime,
                             @NotBlank LocalTime endTime) {
}
