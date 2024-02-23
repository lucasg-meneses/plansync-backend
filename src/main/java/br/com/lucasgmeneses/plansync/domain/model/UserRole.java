package br.com.lucasgmeneses.plansync.domain.model;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER");
    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
