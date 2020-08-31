package com.genetics.qmslogApi.controller;


import com.genetics.qmslogApi.model.Teller;
import com.genetics.qmslogApi.service.MapValidationServiceError;
import com.genetics.qmslogApi.service.TellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/teller/")
public class TellerController {

    @Autowired
    TellerService tellerService;

    @Autowired
    TellerController tellerController;
    @Autowired
    MapValidationServiceError mapValidationServiceError;

//    @GetMapping
//    public List<Teller> getAllTellers(){
//
//    }

    @PostMapping("")
    public ResponseEntity<?> createNewTeller(@Valid @RequestBody Teller teller, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationServiceError.MapValidationService(result);
        if(errorMap!= null) return errorMap;
            Teller teller1 = tellerService.createTeller(teller);
         return new ResponseEntity<Teller>(teller1, HttpStatus.CREATED);
    }

}
