package br.com.lucasgmeneses.plansync.domain.model;

import lombok.Getter;

@Getter
public enum Language {
    PT_BR("Português Brasileiro"),
    EN("English");

    private final String name;

    Language(String name) {
        this.name = name;
    }
}
