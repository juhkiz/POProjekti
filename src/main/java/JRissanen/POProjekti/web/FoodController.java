package JRissanen.POProjekti.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import JRissanen.POProjekti.domain.Food;
import JRissanen.POProjekti.domain.FoodRepository;

@CrossOrigin
@Controller
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepo;
	
	@RequestMapping(value="/foodlist")
	public String foodList(Model model) {
		model.addAttribute("foods", foodRepo.findAll());
		return "foodlist";
	}
	
	@RequestMapping(value = "/addfood")
    public String addBook(Model model){
    	model.addAttribute("food", new Food());
        return "addfood";
    }
	@RequestMapping(value = "/saveFood", method = RequestMethod.POST)
    public String save(Food food){
        foodRepo.save(food);
        return "redirect:foodlist"; 
    }
	@RequestMapping(value="/foods", method = RequestMethod.GET)
    public @ResponseBody List<Food> foodlistRest() {	
        return (List<Food>) foodRepo.findAll();
    }
}
