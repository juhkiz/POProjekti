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
import JRissanen.POProjekti.domain.Sport;
import JRissanen.POProjekti.domain.SportRepository;

@CrossOrigin
@Controller
public class SportController {
	
	@Autowired
	private SportRepository sportRepo;
	
	@RequestMapping(value="/sportlist")
	public String sportList(Model model) {
		model.addAttribute("sports", sportRepo.findAll());
		return "sportlist";
	}
	
	@RequestMapping(value = "/addsport")
    public String addBook(Model model){
    	model.addAttribute("sport", new Sport());
        return "addsport";
    }
	@RequestMapping(value = "/saveSport", method = RequestMethod.POST)
    public String save(Sport sport){
        sportRepo.save(sport);
        return "redirect:sportlist";
    }
	@RequestMapping(value="/sports", method = RequestMethod.GET)
    public @ResponseBody List<Sport> foodlistRest() {
        return (List<Sport>) sportRepo.findAll();
    }
}
