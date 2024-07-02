package br.com.lucasgmeneses.plansync.domain.dto.todo;

import br.com.lucasgmeneses.plansync.domain.model.TodoModel;
import br.com.lucasgmeneses.plansync.domain.model.Weekday;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

public record TodoResponseDto(@NotBlank String id,
                              @NotBlank String title,
                              @NotNull String description,
                              @NotBlank String weekday,
                              @NotNull String plannerId,
                              @NotBlank LocalTime startTime,
                              @NotBlank LocalTime endTime) {
    public TodoResponseDto(TodoModel todoModel){
        this(todoModel.getId(),
                todoModel.getTitle(),
                todoModel.getDescription(),
                todoModel.getWeekday(),
                todoModel.getPlanner().getId(),
                todoModel.getStartTime(),
                todoModel.getEndTime()
        );
    }
}
