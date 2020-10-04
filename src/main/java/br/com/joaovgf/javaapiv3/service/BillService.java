package br.com.joaovgf.javaapiv3.service;


import br.com.joaovgf.javaapiv3.controller.dto.BillRequest;
import br.com.joaovgf.javaapiv3.controller.dto.BillResponse;

import java.util.List;

public interface BillService {


    void saveBill(BillRequest billRequest) throws Exception;

    List<BillResponse> findAll();

    BillResponse findById(Long id);

}
