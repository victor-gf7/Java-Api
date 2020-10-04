package br.com.joaovgf.javaapiv3.controller;

import br.com.joaovgf.javaapiv3.controller.dto.BillRequest;
import br.com.joaovgf.javaapiv3.controller.dto.BillResponse;
import br.com.joaovgf.javaapiv3.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/bill")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/")
    public List<BillResponse> findAll(){
        return billService.findAll();
    }

    @GetMapping("/{id}")
    public BillResponse findById(@PathVariable("id") Long id){
        return billService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> saveBill(@RequestBody BillRequest billRequest) throws Exception {
        try {
            billService.saveBill(billRequest);
            return new ResponseEntity<>("account payable included", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
