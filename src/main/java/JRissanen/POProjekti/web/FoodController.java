package JRissanen.POProjekti.web;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/addfood", method=RequestMethod.GET)
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
	@RequestMapping(value="/addfood", method=RequestMethod.POST)
	public String foodSubmit(@Valid Food food, BindingResult bindingResult, Model model) {
	 if (bindingResult.hasErrors()) {
	 return "addfood";
	 }
	 else {
		return "foodmessage";
	 }
	}
	@PreAuthorize(value = "hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteFood(@PathVariable("id") Long foodId, Model model) {
    	foodRepo.deleteById(foodId);
        return "redirect:../foodlist";
    }
	 @RequestMapping(value = "/editfood/{id}")
	    public String editFood(@PathVariable("id") Long foodId, Model model){
	    	model.addAttribute("food", foodRepo.findById(foodId));
	    	return "editfood";
	    }
	  @RequestMapping(value = "/savefood", method = RequestMethod.POST)
	    public String saveEdit(Food food){
	        foodRepo.save(food);
	        return "redirect:foodlist"; 
	    }
}
