package com.brew.brewery.service;

import com.brew.brewery.BeerException;
import com.brew.brewery.model.Beer;
import com.brew.brewery.repository.BeerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BeerServiceImplement implements BeerService{

    @Autowired
    private BeerRepository beerRepository;
    @Override
    public Beer createBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public Beer updateBeer(Beer beer) {
        Optional<Beer> beerObj = this.beerRepository.findById(beer.getBeerCode());
        if(beerObj.isPresent()){
            Beer beerUpdate = beerObj.get();
            beerUpdate.setBeerCode(beer.getBeerCode());
            beerUpdate.setPrice(beer.getPrice());
            beerUpdate.setQuantityInML(beer.getQuantityInML());
            return this.beerRepository.save(beerUpdate);
        }
        else{
            throw new BeerException("Beer was not found with this Beer Code : "+ beer.getBeerCode());
        }
    }

    @Override
    public List<Beer> getAllBeers() {
        return this.beerRepository.findAll();
    }

    @Override
    public Beer getBeerByCode(long beerCode) {
        Optional<Beer> beerObj = this.beerRepository.findById(beerCode);
        if(beerObj.isPresent()){
            return beerObj.get();
        }
        else{
            throw new BeerException("Beer was not found with this Beer Code : "+ beerCode);
        }
    }

    @Override
    public Beer getBeerByQuantity(long price) throws BeerException {
        System.out.println("Amount = "+price);
        Beer beerObj;
        try{
            beerObj = beerRepository.findById(price).get();
        }
        catch (Exception e){
            throw new BeerException("Please enter multiples of 10 and less than 3000");
        }
        if(beerObj!=null){
            return beerObj;
        }
        else{
            return null;
        }
//        return beerObj;
    }

    @Override
    public void deleteBeer(long beerCode) {
        Optional<Beer> beerObj = this.beerRepository.findById(beerCode);
        if(beerObj.isPresent()){
            this.beerRepository.deleteById(beerCode);
        }
        else {
            throw new BeerException("Beer was not found with this Beer Code : "+ beerCode);
        }
    }
}
