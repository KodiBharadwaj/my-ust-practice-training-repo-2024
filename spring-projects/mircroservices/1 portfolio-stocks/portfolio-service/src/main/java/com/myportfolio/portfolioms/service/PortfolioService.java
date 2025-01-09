package com.myportfolio.portfolioms.service;

import com.myportfolio.portfolioms.model.Portfolio;

import javax.sound.sampled.Port;

public interface PortfolioService {

    public Portfolio createPortfolio(Portfolio portfolio);

    public Portfolio getPortfolioById(String id);
}
