package com.codecrew.currencyexchangeservice.dal;

import com.codecrew.currencyexchangeservice.domain.model.CurrencyExchange;

public interface ICurrencyExchangeRepository {

    CurrencyExchange getCurrencyExchangeByFromAndTo(String from, String to);

}
