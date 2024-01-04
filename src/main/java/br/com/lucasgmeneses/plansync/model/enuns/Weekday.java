package br.com.lucasgmeneses.plansync.model.enuns;

import lombok.Getter;

@Getter
public enum Weekday {
    MONDAY("Monday", "Segunda-feira"),
    TUESDAY("Tuesday", "terça-feira"),
    WEDNESDAY("Wednesday", "Quarta-feira"),
    THURSDAY("Thursday", "Quinta-feira"),
    FRIDAY("Friday", "Sexta-feira"),
    SATURDAY("Saturday", "Sábado"),
    SUNDAY("Sunday","Domingo");

    private final String dayNameEn;
    private final String dayNamePt;

    Weekday(String dayNameEn, String dayNamePt) {
        this.dayNameEn = dayNameEn;
        this.dayNamePt = dayNamePt;
    }
    public String geDayName(Language language){
        String dayName = switch (language) {
            case PT_BR -> getDayNamePt();
            case EN -> getDayNameEn();
            default -> throw new IllegalStateException("Unexpected value : "+ language);
        };
        return dayName;
    }
}


