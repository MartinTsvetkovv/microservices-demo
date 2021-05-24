package com.codecrew.currencyexchangeservice.dal;

import com.codecrew.currencyexchangeservice.domain.model.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface CurrencyExchangeJpaRepository extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findCurrencyExchangeByFromAndTo(String from, String to);

}

@Repository
class CurrencyExchangeRepository implements ICurrencyExchangeRepository{


    private final CurrencyExchangeJpaRepository currencyExchangeJpaRepository;

    @Autowired
    CurrencyExchangeRepository(CurrencyExchangeJpaRepository currencyExchangeJpaRepository) {
        this.currencyExchangeJpaRepository = currencyExchangeJpaRepository;
    }


    @Override
    public CurrencyExchange getCurrencyExchangeByFromAndTo(String from, String to) {
        return this.currencyExchangeJpaRepository.findCurrencyExchangeByFromAndTo(from, to);
    }
}

