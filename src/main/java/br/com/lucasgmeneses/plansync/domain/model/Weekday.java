package br.com.lucasgmeneses.plansync.domain.model;

import lombok.Getter;

@Getter
public enum Weekday {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private final String dayName;


    Weekday(String dayName) {
        this.dayName = dayName;
    }
}


