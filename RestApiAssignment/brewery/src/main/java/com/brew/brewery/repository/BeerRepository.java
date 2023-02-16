package com.brew.brewery.repository;

import com.brew.brewery.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BeerRepository extends JpaRepository<Beer,Long> {


    @Query(nativeQuery = true,value = "Select beer quantity according to price")
    Beer getBeerByQuantity(long price);

}