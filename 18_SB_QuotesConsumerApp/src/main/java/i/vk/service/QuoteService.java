 package i.vk.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import i.vk.binder.Quote;
import i.vk.binder.QuoteToList;

@Service
public class QuoteService {
	
	public Quote getOneRandomQuote(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Quote> forEntity = restTemplate.getForEntity("https://dummyjson.com/quotes/random", Quote.class);
		if(forEntity != null){
			return forEntity.getBody();
		}
		return null;
	}
	
	public List<Quote> getAllQuotes(){
		RestTemplate rt = new RestTemplate();
		QuoteToList quotes = rt.getForObject("https://dummyjson.com/quotes", QuoteToList.class);
		return quotes!=null? quotes.getQuotes():null;
	}
}
