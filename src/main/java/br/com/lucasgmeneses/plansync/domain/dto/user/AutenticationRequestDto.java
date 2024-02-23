package br.com.lucasgmeneses.plansync.domain.dto.user;

import jakarta.validation.constraints.NotBlank;

public record AutenticationRequestDto(@NotBlank String login, @NotBlank String password) {
}
