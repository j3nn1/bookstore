package fi.jenniriikonen.bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.jenniriikonen.bookstore.domain.Book;


@Controller
@ResponseBody

public class BookController {
	
	public ArrayList<String> books = new ArrayList<String>();
	
	//url:ssä "index" käynnistää tämän osion
	@GetMapping(value="index") 
	public String start() {
		return "Here we go!";
	}
	
}
