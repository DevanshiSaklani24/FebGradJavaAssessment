package com.coffee.coffeedispenser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/coffee")
    public class CoffeeController {

        @Autowired
        CoffeeService coffeeService;

        @PostMapping("/setQuantities")
        public String saveQuantities(){
            coffeeService.saveAllRecords();
            return "Records are created";
        }

        @GetMapping("/allQuantities")
        public List<Coffee> allQuantities(){
            return coffeeService.getAllDetails();
        }

        @GetMapping("/menu")
        public List<String> menu(){
            return coffeeService.getMenu();
        }

        @GetMapping("/type/{name}")
        public ResponseEntity<Coffee> getCoffee(@PathVariable String name) throws CoffeeException {
            System.out.println(coffeeService.getDetails(name));
            return ResponseEntity.ok(coffeeService.getDetails(name));
        }
    }

}
