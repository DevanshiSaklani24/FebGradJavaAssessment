package com.coffee.coffeedispenser.service;

import com.coffee.coffeedispenser.exception.CoffeeException;
import com.coffee.coffeedispenser.model.Coffee;

import java.util.List;

public interface CoffeeService {
    void saveAllRecords();

    Coffee getDetails(String name) throws CoffeeException;

    List<String> getMenu();

    List<Coffee> getAllDetails();
}
