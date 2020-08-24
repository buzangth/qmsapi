package com.genetics.qmslogApi.service;

import com.genetics.qmslogApi.model.Teller;
import com.genetics.qmslogApi.repository.TellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TellerService {
    @Autowired
    TellerRepository tellerRepository;

    public Teller createTeller(Teller teller) {

        System.out.println(teller);
        return tellerRepository.save(teller);

    }
}
