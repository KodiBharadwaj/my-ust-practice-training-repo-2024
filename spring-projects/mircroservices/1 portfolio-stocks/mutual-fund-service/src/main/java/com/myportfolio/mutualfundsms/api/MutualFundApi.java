package com.myportfolio.mutualfundsms.api;

import com.myportfolio.mutualfundsms.model.MutualFund;
import com.myportfolio.mutualfundsms.repository.MutualFundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutualfund")
public class MutualFundApi {

    @Autowired
    private MutualFundRepository mutualFundRepository;

    @PostMapping
    public MutualFund addMutualFund(@RequestBody MutualFund mutualFund){
        return mutualFundRepository.save(mutualFund);
    }

    @GetMapping("{id}")
    public MutualFund getMutualFundById(@PathVariable("id") int id){
        return mutualFundRepository.findById(id).orElseThrow(()->new RuntimeException("Mutual Fund with id " + id + " is not found"));
    }
}
