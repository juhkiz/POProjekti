package JRissanen.POProjekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
