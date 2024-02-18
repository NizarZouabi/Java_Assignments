package com.assignment.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment.loginandregistration.models.LoginUser;
import com.assignment.loginandregistration.models.User;
import com.assignment.loginandregistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User newUser,
    		@ModelAttribute("newLogin") LoginUser newLogin) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
    	Long userId = (Long) session.getAttribute("userId");
    	String userName = (String) session.getAttribute("username");
    	if(userId == null) {
    		return "redirect:/";
    	} else {
    		model.addAttribute("userId", userId);
    		model.addAttribute("userName", userName);
    		return "home.jsp";
    	}
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
    	User user = userService.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }
        
        userService.register(newUser, result);
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUserName());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        } else {
        	session.setAttribute("userId", user.getId());
        	session.setAttribute("username", user.getUserName());
        	return "redirect:/home";
        }
      }
    
    @PostMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

}
