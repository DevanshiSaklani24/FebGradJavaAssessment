package com.currency.exchange.Controller;

import com.currency.exchange.Service.DataFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
//import okhttp3.*;

@RestController
public class RateController {
    @Autowired
    private DataFetchService fetchService;

    @GetMapping("/fetchrate")
    public void FetchApiData(@RequestParam Optional<String> date) {
        if(date.isPresent()){
            fetchService.getApiData(date.get());
        }else{
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            fetchService.getApiData(simpleDateFormat.format(new Date()));
        }

    }
}