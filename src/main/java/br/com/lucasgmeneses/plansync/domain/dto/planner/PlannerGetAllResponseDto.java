package br.com.lucasgmeneses.plansync.domain.dto.planner;

import br.com.lucasgmeneses.plansync.domain.model.PlannerModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record PlannerGetAllResponseDto(@NotBlank String id,
                                       @NotBlank String title,
                                       @NotNull Long month,
                                       @NotNull Long year,
                                       @NotNull Date dateUpdated) {
    public PlannerGetAllResponseDto(PlannerModel plannerModel){
        this(plannerModel.getId(),
                plannerModel.getTitle(),
                plannerModel.getMonth(),
                plannerModel.getYear(),
                plannerModel.getDateUpdated()
        );
    }
}
