package com.genetics.qmslogApi.controller;


import com.genetics.qmslogApi.model.Teller;
import com.genetics.qmslogApi.service.TellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teller/")
public class TellerController {

    @Autowired
    TellerService tellerService;

    @PostMapping
    public Teller registerNewTeller(@RequestBody Teller teller){
        return tellerService.createTeller(teller);
    }

}
