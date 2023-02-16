package com.coffee.coffeedispenser.repository;

import com.coffee.coffeedispenser.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoffeeRepository extends JpaRepository<Coffee,Long> {

    @Query(nativeQuery = true,value = "select * from coffee where coffee_name=?1")
    Coffee findByName(String name);
}
