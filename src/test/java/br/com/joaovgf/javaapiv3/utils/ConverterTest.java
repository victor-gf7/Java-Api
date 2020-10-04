package br.com.joaovgf.javaapiv3.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ConverterTest {

    @Test
    void converterDate() throws Exception {
        Converter converter = new Converter();
        String date = "20/10/2020";

        converter.converterDate(date);

        LocalDate expectedDate = LocalDate.of(2020,10,20);

        Assertions.assertEquals(expectedDate,converter.converterDate(date));

    }

}