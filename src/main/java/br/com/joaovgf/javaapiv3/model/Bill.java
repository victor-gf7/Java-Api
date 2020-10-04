package br.com.joaovgf.javaapiv3.model;


import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Name is a required attribute")
    private String name;

    @Column(name = "original_value")
    @NotNull(message = "Original Value is a required attribute")
    private double originalValue;

    @Column(name = "due_date")
    @NotNull(message = "Due date is a required attribute")
    private LocalDate dueDate;

    @Column(name = "payday")
    @NotNull(message = "Payday is a required attribute")
    private LocalDate payday;

    @Column(name = "delayed_days")
    private Long delayedDays;

    @Column(name = "penalty")
    private int penalty;

    @Column(name = "interest")
    private double interest;

    @Column(name = "final_value")
    private double finalValue;

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }
}
