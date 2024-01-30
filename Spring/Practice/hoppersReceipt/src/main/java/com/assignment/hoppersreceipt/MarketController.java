package com.assignment.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarketController {
	@RequestMapping("/")
    public String index(Model model) {
        
        String name = "John Doe";
        String itemName = "Compound X";
        double price = 10.25;
        String description = "Red sugar, also an illustration of nanites.";
        String vendor = "All Weird Things Corner Store";
    
    	model.addAttribute("name", name);
    	model.addAttribute("item", itemName);
    	model.addAttribute("price", price);
    	model.addAttribute("description", description);
    	model.addAttribute("vendor", vendor);
    
        return "index.jsp";
    }
}
