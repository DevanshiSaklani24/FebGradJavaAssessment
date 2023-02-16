package com.coffee.coffeedispenser.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "coffee")
public class Coffee{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long coffeeId;

    @Column(name = "coffee_name")
    private String coffeeName;

    @Column(name = "waterQuantity")
    private float waterQuantity;

    @Column(name = "milkQuantity")
    private float milkQuantity;

    @Column(name = "coffeeQuantity")
    private float coffeeQuantity;

    public float getCoffeeQuantity() {
        return coffeeQuantity;
    }

    public void setCoffeeQuantity(float coffeeQuantity) {
        this.coffeeQuantity = coffeeQuantity;
    }

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public float getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(float waterQuantity) {
        this.waterQuantity = waterQuantity;
    }

    public float getMilkQuantity() {
        return milkQuantity;
    }

    public void setMilkQuantity(float milkQuantity) {
        this.milkQuantity = milkQuantity;
    }

    public Coffee( String coffeeName, float waterQuantity, float milkQuantity,float coffeeQuantity) {
        this.coffeeName = coffeeName;
        this.waterQuantity = waterQuantity;
        this.milkQuantity = milkQuantity;
        this.coffeeQuantity=coffeeQuantity;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeId=" + coffeeId +
                ", coffeeName='" + coffeeName + '\'' +
                ", waterQuantity=" + waterQuantity +
                ", milkQuantity=" + milkQuantity +
                ", coffeeQuantity=" + coffeeQuantity +
                '}';
    }

    public Coffee(){}
}
