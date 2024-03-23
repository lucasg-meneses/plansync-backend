package br.com.lucasgmeneses.plansync.domain.dto.todo;

import br.com.lucasgmeneses.plansync.domain.model.Weekday;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalTime;

public record TodoRequestDto(@NotBlank String title,
                             String description,
                             @NotNull String weekday,
                             @NotBlank String idPlanner,
                             @NotBlank String startTime,
                             @NotBlank String endTime) {
}
