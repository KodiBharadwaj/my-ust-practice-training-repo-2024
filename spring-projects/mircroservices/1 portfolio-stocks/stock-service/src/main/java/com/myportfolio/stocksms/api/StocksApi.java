package com.myportfolio.stocksms.api;

import com.myportfolio.stocksms.dto.StockInputList;
import com.myportfolio.stocksms.model.Stock;
import com.myportfolio.stocksms.repository.StocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StocksApi {

    @Autowired
    private StocksRepository stocksRepository;

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable("id") int id){
        return stocksRepository.findById(id).orElseThrow(()->new RuntimeException("No Stock with id " + id + " found"));
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock){
        return stocksRepository.save(stock);
    }

//    @GetMapping
//    public List<Stock> getAllStocks(){
//        return stocksRepository.findAll();
//    }

    @PostMapping("/all")
    public List<Stock> getAllByIds(@RequestBody StockInputList stockInputs){
        return stocksRepository.findAllById(stockInputs.ids());
    }
}
