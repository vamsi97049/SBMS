package i.vk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import i.vk.binder.Quote;
import i.vk.service.QuoteService;

@Controller
public class QuoteController {
	@Autowired
	private QuoteService service;
	
	@GetMapping("/")
	public String defaultRoute() {
		return "home";
	}
	
	@GetMapping("/getOne")
	public String singleQuote(Model model) {
		Quote randomQuote = service.getOneRandomQuote();
		model.addAttribute("quote",randomQuote);
		return "quote";
	}	
	
	@GetMapping("/getAll")
	public String allQuotes(Model model) {
		List<Quote> allQuotes = service.getAllQuotes();
		model.addAttribute("quotes",allQuotes);
		return "quotes";
	}
	
	@ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("exception", ex);
        return "error"; 
    }
	
}
