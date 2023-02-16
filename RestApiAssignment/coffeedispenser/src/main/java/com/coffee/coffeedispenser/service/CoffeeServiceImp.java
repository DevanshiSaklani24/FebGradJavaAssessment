package com.coffee.coffeedispenser.service;

import com.coffee.coffeedispenser.exception.CoffeeException;
import com.coffee.coffeedispenser.model.Coffee;
import com.coffee.coffeedispenser.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CoffeeServiceImp implements CoffeeService{

    @Autowired
    CoffeeRepository coffeeRepository;

    @Override
    public void saveAllRecords() {
        List<Coffee> list=new ArrayList<>();
        Coffee coffee;
        coffee = new Coffee("Latte",20.00f,50.00f,30.00f);
        list.add(coffee);
        coffee =new Coffee("Cappuccino",5.00f,35.00f,60.00f);
        list.add(coffee);
        coffee=new Coffee("Espresso",5.00f,25.00f,70.00f);
        list.add(coffee);
        coffee=new Coffee("Milk",0.00f,100.00f,0.00f);
        list.add(coffee);
        coffee=new Coffee("Water",100.00f,0.00f,0.00f);
        list.add(coffee);
        coffeeRepository.saveAll(list);
    }

    @Override
    public Coffee getDetails(String name) throws CoffeeException {
        Coffee coffee;
        try {
            coffee = coffeeRepository.findByName(name);
        }
        catch (Exception e){
            throw new CoffeeException("Its not an option from the menu");
        }
        if(coffee!=null)
            return coffee;
        else
            return null;
    }

    @Override
    public List<String> getMenu(){
        List<String> list=new ArrayList<>(Arrays.asList("Cappuccino","Latte","Espresso","Milk","Steam","Water"));
        return list;
    }

    @Override
    public List<Coffee> getAllDetails() {
        return coffeeRepository.findAll();
    }


}