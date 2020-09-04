package fi.jenniriikonen.bookstore.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import fi.jenniriikonen.bookstore.domain.Book;
import fi.jenniriikonen.bookstore.domain.BookRepository;


@Controller

public class BookController {
	//Reporistory will be injected to controller
	@Autowired
	private BookRepository repository;
	
	//url booklist
	@RequestMapping("/booklist") 
	public String bookList(Model model) {
		//model attribute gets key books (NOTE! this is key in view) and value is all books
		//findAll will get all data from 
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }  
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }   
	
}
