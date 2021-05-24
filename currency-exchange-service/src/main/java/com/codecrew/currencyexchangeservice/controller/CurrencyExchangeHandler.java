package com.codecrew.currencyexchangeservice.controller;

import com.codecrew.currencyexchangeservice.dal.ICurrencyExchangeRepository;
import com.codecrew.currencyexchangeservice.domain.model.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeHandler {

    private final Environment environment;
    private final ICurrencyExchangeRepository currencyExchangeRepository;

    @Autowired
    public CurrencyExchangeHandler(Environment environment, ICurrencyExchangeRepository currencyExchangeRepository) {
        this.environment = environment;
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        //final CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
        final CurrencyExchange currencyExchange = this.currencyExchangeRepository.getCurrencyExchangeByFromAndTo(from, to);
        final String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
