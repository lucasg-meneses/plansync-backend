package br.com.lucasgmeneses.plansync.domain.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(@NotBlank String login,
                             @NotBlank String password,
                             @NotBlank String email) {
}
