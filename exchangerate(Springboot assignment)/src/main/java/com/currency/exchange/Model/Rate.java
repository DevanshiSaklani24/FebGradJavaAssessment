package com.currency.exchange.Model;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rate {
    String success;
    Timestamp timestamp;
    Boolean historical;
    String base;
    Date date;
    ConvClass rates;


}
