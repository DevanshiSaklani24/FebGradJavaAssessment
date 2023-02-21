package com.currency.exchange.Service;


import com.currency.exchange.Model.Audit;
import com.currency.exchange.Model.Rate;
import com.currency.exchange.repository.AuditRepository;
import com.currency.exchange.utils.Csvfilewriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Service
public class DataFetchService {
	@Autowired
	private AuditRepository auditRepository;
	String arr[]= {"AED","CAD","EUR","INR","JPY"};
	public void getApiData(String date) {
		FutureTask<Rate>[] tasks = new FutureTask[6];
		Audit[] infos=new Audit[6];
		try {
			
			for(int i=0;i< arr.length;i++) {
				String st="https://api.apilayer.com/exchangerates_data/"+date+"?symbols=USD&base="+arr[i];

				Callable<Rate> clble = new DataFetchApi(st);
				tasks[i] = new FutureTask<Rate>(clble);

				Audit info=new Audit();
				info.setRequest(st);
				info.setCreate_ts(new Timestamp(new Date().getTime()));
				info.setStatus("SENT_THE_REQ");
				infos[i]=auditRepository.save(info);

			    Thread th = new Thread(tasks[i]);  
			    th.start();  
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int j = 0; j < arr.length; j++)
	    {

			try {
				Audit info=infos[j];
				info.setResponse(tasks[j].get().toString());
				info.setUpdate_ts(tasks[j].get().getTimestamp());
				info.setStatus("RECEIVED_RESPONSE");
				new Csvfilewriter(tasks[j].get());
				auditRepository.save(info);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }  
	}
	
}
