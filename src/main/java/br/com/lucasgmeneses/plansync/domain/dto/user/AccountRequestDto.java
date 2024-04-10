package br.com.lucasgmeneses.plansync.domain.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AccountRequestDto (@NotBlank String username, @NotBlank String email, @NotNull String password){}
