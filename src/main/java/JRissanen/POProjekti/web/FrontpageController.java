package JRissanen.POProjekti.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import JRissanen.POProjekti.domain.FoodRepository;
import JRissanen.POProjekti.domain.SportRepository;

@CrossOrigin
@Controller
public class FrontpageController {
	
	@Autowired
	private SportRepository sportRepo;
	@Autowired
	private FoodRepository foodRepo;
	
	@RequestMapping(value="/frontpage")
	public String sportList(Model model) {
		model.addAttribute("sports", sportRepo.findAll());
		model.addAttribute("foods", foodRepo.findAll());
		return "frontpage";
	}
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
}
