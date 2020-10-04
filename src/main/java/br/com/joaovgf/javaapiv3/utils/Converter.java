package br.com.joaovgf.javaapiv3.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Converter {

    public LocalDate converterDate (String date) throws Exception {
        LocalDate dateConverted;

        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dateConverted = LocalDate.parse(date, formatter);

            return dateConverted;
        } catch (Exception e){
            throw new Exception("Could not enter data information.");
        }
    }
}
