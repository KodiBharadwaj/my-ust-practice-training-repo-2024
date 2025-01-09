package com.myportfolio.portfolioms.service;

import com.myportfolio.portfolioms.dto.MutualFund;
import com.myportfolio.portfolioms.dto.Stock;
import com.myportfolio.portfolioms.dto.StockInputList;
import com.myportfolio.portfolioms.model.Portfolio;
import com.myportfolio.portfolioms.repository.PortfolioRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PortfolioServiceImplementation implements PortfolioService{

    // RestTemplate
    // WebClient
    // Feign Client
    // Http Client

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        Portfolio savedPortfolio =  portfolioRepository.save(portfolio);
        savedPortfolio.setTotalValue(fetchTotalValue(portfolio));
        savedPortfolio.setTotalMutualFundValue(fetchTotalMutualValue(portfolio));
        return savedPortfolio;
    }

    @Override
    public Portfolio getPortfolioById(String id) {
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow(()->new RuntimeException("No Portfolio found"));
        //RestTemplate method
        portfolio.setTotalValue(fetchTotalValue(portfolio));
        portfolio.setTotalMutualFundValue(fetchTotalMutualValue(portfolio));
        return portfolio;
    }


//    @CircuitBreaker(fallbackMethod = "fetchTotalValueFallback", name = "stocks-service-cb")
//    public double fetchTotalValue(Portfolio portfolio){
//
//        double totalValue = 0;
//        for(int stockId : portfolio.getStocks()){
//            Stock stock = restTemplate.getForObject("http://STOCK-SERVICE/stocks/" + stockId, Stock.class);
//            totalValue += stock.getPrice();
//        }
//
//        return totalValue;
//    }
    public double fetchTotalValue(Portfolio portfolio){

        double totalValue = 0;

        List<Integer> stockIdList = new ArrayList<>();
        for (int stockId : portfolio.getStocks()) {
            //Stock stock = restTemplate.getForObject("http://STOCK-SERVICE/stocks/" + stockId, Stock.class);
            //totalValue += stock.getPrice();
            stockIdList.add(stockId);
        }
        StockInputList stockInputList = new StockInputList(stockIdList);
        Stock[] stocks = restTemplate.postForObject("http://STOCK-SERVICE/stocks/all", stockInputList, Stock[].class);

        for(Stock i: stocks){
            totalValue +=i.getPrice();
        }
        return totalValue;
    }





    public double fetchTotalMutualValue(Portfolio portfolio){
        double totalMutualFundValue = 0;
        for(int mutualId : portfolio.getMutualFunds()){
            MutualFund mutualFund = restTemplate.getForObject("http://MUTUAL-FUND-SERVICE/mutualfund/" + mutualId, MutualFund.class);
            totalMutualFundValue += mutualFund.getAmountInvested();
        }
        return totalMutualFundValue;
    }

}
