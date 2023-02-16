package com.brew.brewery.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="beers")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "beeCode")
    private long beerCode;



    @Column(name="price")
    private long price;

    @Column(name = "quantityInML")
    private long quantityInML;

    @CreationTimestamp
    private Date createdTime;

    public long getBeerCode() {
        return beerCode;
    }

    public void setBeerCode(long beerCode) {
        this.beerCode = beerCode;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantityInML() {
        return quantityInML;
    }

    public void setQuantityInML(long quantityInML) {
        this.quantityInML = quantityInML;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}