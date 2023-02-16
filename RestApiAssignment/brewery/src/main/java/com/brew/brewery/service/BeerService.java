package com.brew.brewery.service;

import com.brew.brewery.BeerException;
import com.brew.brewery.model.Beer;

import java.util.List;

public interface BeerService {
    Beer createBeer(Beer beer);
    Beer updateBeer(Beer beer);
    List<Beer> getAllBeers();
    Beer getBeerByCode(long beerCode);
    Beer getBeerByQuantity(long price) throws BeerException;
    void deleteBeer(long beerCode);
}