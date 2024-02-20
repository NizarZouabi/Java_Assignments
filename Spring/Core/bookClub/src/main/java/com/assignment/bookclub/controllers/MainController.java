package com.assignment.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.bookclub.models.Book;
import com.assignment.bookclub.models.LoginUser;
import com.assignment.bookclub.models.User;
import com.assignment.bookclub.services.BookService;
import com.assignment.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
    private UserService userService;
	
	@Autowired
	private BookService bookService;
    
    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User newUser,
    		@ModelAttribute("newLogin") LoginUser newLogin) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @GetMapping("/books")
    public String home(Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	String userName = (String) session.getAttribute("userName");
    	List<Book> books = bookService.getBooks();
    	model.addAttribute("books", books);
    	if(userId == null) {
    		return "redirect:/";
    	} else {
    		model.addAttribute("userId", userId);
    		model.addAttribute("userName", userName);
    		return "dashboard.jsp";
    	}
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	User user = userService.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        userService.register(newUser, result);
        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getName());
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        } else {
        	session.setAttribute("userId", user.getId());
        	session.setAttribute("userName", user.getName());
        	return "redirect:/books";
        }
      }
    
    @PostMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/book/new")
    public String addBook(@ModelAttribute("book") Book book, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
    	return "create.jsp";
    }
    
    @PostMapping("/book/create")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
    	Long id = (Long) session.getAttribute("userId");
		User user = userService.findUser(id);
    	if(result.hasErrors()) {
    		return "create.jsp";
    	} else {
    		book.setUser(user);
    		bookService.createBook(book);
    		return "redirect:/books";
    	}
    }
    
    @GetMapping("/book/{bookId}/details")
    public String bookDetails(@PathVariable(value="bookId") Long id,HttpSession session, Model model) {
    	Book book = bookService.getBook(id);
    	model.addAttribute("book", book);
    	Long userId = (Long) session.getAttribute("userId");
    	model.addAttribute("userId", userId);
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
    	return "details.jsp";
    }
    
    @GetMapping("/book/{bookId}/edit")
    public String editBook(@ModelAttribute("book") Book book, @PathVariable(value="bookId") Long id, Model model, HttpSession session) {
    	Book bookToEdit = bookService.getBook(id);
    	model.addAttribute("book", bookToEdit);
    	Long userId = (Long) session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/";
    	}
    	
    	return "edit.jsp";
    	
    }
    
    @PatchMapping("/book/{bookId}/update")
    public String updateBook(@PathVariable(value="bookId") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
    	model.addAttribute("bookId", id);
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	} else {
    		bookService.updateBook(id, book);
    		return "redirect:/book/{bookId}/details";
    	}
    }
    
    @DeleteMapping("/book/{bookId}/delete")
    public String deleteBook(@PathVariable(value="bookId") Long id) {
    	bookService.deleteBook(id);
    	return "redirect:/books";
    }

}
