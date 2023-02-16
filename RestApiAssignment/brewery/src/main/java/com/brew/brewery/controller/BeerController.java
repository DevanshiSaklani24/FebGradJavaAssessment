package com.brew.brewery.controller;

import com.brew.brewery.BeerException;
import com.brew.brewery.model.Beer;
import com.brew.brewery.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping("/beers/all")
    private ResponseEntity<List<Beer>> getAllBeers(){
        return ResponseEntity.ok().body(this.beerService.getAllBeers());
    }

    @GetMapping("/beer/{beerCode}")
    private Beer getBeerByCode(@PathVariable long beerCode){
        return this.beerService.getBeerByCode(beerCode);
    }

    @GetMapping("/beer/quantity")
    private ResponseEntity<String> getBeerByQuantity(@RequestParam long price) throws BeerException {
        Beer br = beerService.getBeerByQuantity(price);
        return ResponseEntity.ok("This quantity of beer is "+br.getQuantityInML()+" ml for "+price+"rupees");
    }

    @PostMapping("/beer/create")
    private ResponseEntity<Beer> saveProduct(@RequestBody Beer beer){
        return ResponseEntity.ok().body(this.beerService.createBeer(beer));
    }

    @PutMapping("/beer/{beerCode}")
    private ResponseEntity<Beer> updateBeer(@PathVariable long beerCode , @RequestBody Beer beer){
        beer.setBeerCode(beerCode);
        return ResponseEntity.ok().body(this.beerService.updateBeer(beer));
    }

    @DeleteMapping("/beer/delete/{beerCode}")
    private HttpStatus deleteBeer(@PathVariable long beerCode){
        this.beerService.deleteBeer(beerCode);
        return HttpStatus.OK;
    }
}
