package br.com.lucasgmeneses.plansync.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Converter {

    public static LocalTime converterStringToLocalTime(String hoursString){
        // Definindo um formato para a string (HH:mm)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

        try {
            // Convertendo a string em LocalTime usando o formato especificado
            return LocalTime.parse(hoursString, formatter);
        }catch (NullPointerException e){
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }


    }
}
