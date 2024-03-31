package br.com.lucasgmeneses.plansync.domain.dto.user;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record UserResponseDto(@NotBlank String username, @NotBlank String email, @NotBlank Date dateUpdate) {
}
