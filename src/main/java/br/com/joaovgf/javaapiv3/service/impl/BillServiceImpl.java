package br.com.joaovgf.javaapiv3.service.impl;

import br.com.joaovgf.javaapiv3.controller.dto.BillRequest;
import br.com.joaovgf.javaapiv3.controller.dto.BillResponse;
import br.com.joaovgf.javaapiv3.model.Bill;
import br.com.joaovgf.javaapiv3.repository.BillRepository;
import br.com.joaovgf.javaapiv3.service.BillService;
import br.com.joaovgf.javaapiv3.utils.Converter;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public void saveBill(BillRequest billRequest) throws Exception{
        var bill = new Bill();
        Converter converter = new Converter();

            LocalDate dueDate = converter.converterDate(billRequest.getDueDate());
            LocalDate payday = converter.converterDate(billRequest.getPayday());

            Long delayed = ChronoUnit.DAYS.between(dueDate, payday);
            double finalValue = 0, penaltyValue = 0, interestValue = 0;

            if(delayed <= 0){
                bill.setPenalty(0);
                bill.setInterest(0);
                bill.setFinalValue(billRequest.getOriginalValue());
            } else if(delayed <= 3){
                bill.setPenalty(2);
                bill.setInterest(0.1);
                penaltyValue = billRequest.getOriginalValue() * 0.02;
                interestValue = billRequest.getOriginalValue() * (0.001 * delayed);
                finalValue = billRequest.getOriginalValue() + penaltyValue + interestValue;

                bill.setFinalValue(finalValue);

            } else if(delayed <=5){
                bill.setPenalty(3);
                bill.setInterest(0.2);
                penaltyValue = billRequest.getOriginalValue() * 0.03;
                interestValue = billRequest.getOriginalValue() * (0.002 * delayed);
                finalValue = billRequest.getOriginalValue() + penaltyValue + interestValue;

                bill.setFinalValue(finalValue);
            } else {
                bill.setPenalty(5);
                bill.setInterest(0.3);
                penaltyValue = billRequest.getOriginalValue() * 0.05;
                interestValue = billRequest.getOriginalValue() * (0.003 * delayed);
                finalValue = billRequest.getOriginalValue() + penaltyValue + interestValue;

                bill.setFinalValue(finalValue);
            }

            bill.setName(billRequest.getName());
            bill.setOriginalValue(billRequest.getOriginalValue());
            bill.setDueDate(dueDate);
            bill.setPayday(payday);
            bill.setDelayedDays(delayed);

            billRepository.save(bill);

    }

    @Override
    public List<BillResponse> findAll() {
        var bills = billRepository.findAll();
        return bills
                .stream()
                .map(BillResponse::converter)
                .collect(Collectors.toList());
    }

    @Override
    public BillResponse findById(Long id) {
        var bill = billRepository.getOne(id);
        return BillResponse.converter(bill);
    }
}
