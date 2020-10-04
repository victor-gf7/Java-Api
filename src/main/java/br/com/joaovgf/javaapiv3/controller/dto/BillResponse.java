package br.com.joaovgf.javaapiv3.controller.dto;

import br.com.joaovgf.javaapiv3.model.Bill;

import javax.persistence.Column;
import java.time.LocalDate;

public class BillResponse {

    private Long id;
    private String name;
    private double originalValue;
    private double finalValue;
    private Long delayedDays;
    private LocalDate payday;


    public static BillResponse converter(Bill b){
        var bill = new BillResponse();
        bill.setId(b.getId());
        bill.setName(b.getName());
        bill.setOriginalValue(b.getOriginalValue());
        bill.setFinalValue(b.getFinalValue());
        bill.setDelayedDays(b.getDelayedDays());
        bill.setPayday(b.getPayday());

        return  bill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(double originalValue) {
        this.originalValue = originalValue;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public void setPayday(LocalDate payday) {
        this.payday = payday;
    }

    public Long getDelayedDays() {
        return delayedDays;
    }

    public void setDelayedDays(Long delayedDays) {
        this.delayedDays = delayedDays;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }
}
