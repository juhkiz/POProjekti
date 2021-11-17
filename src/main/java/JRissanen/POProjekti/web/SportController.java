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
	
	@RequestMapping(value = "/addsport", method=RequestMethod.GET)
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
	@RequestMapping(value="/addsport", method=RequestMethod.POST)
	public String sportSubmit(@Valid Sport sport, BindingResult bindingResult, Model model) {
	 if (bindingResult.hasErrors()) {
	 return "addsport";
	 }
	 else {
		return "sportmessage";
	 }
	} 
	@PreAuthorize(value = "hasAuthority('ADMIN')")
    @RequestMapping(value = "/deletesport/{id}", method = RequestMethod.GET)
    public String deleteSport(@PathVariable("id") Long sportId, Model model) {
    	sportRepo.deleteById(sportId);
        return "redirect:../sportlist";
    }
	  @RequestMapping(value = "/edit/{id}")
	    public String editBook(@PathVariable("id") Long sportId, Model model){
	    	model.addAttribute("sport", sportRepo.findById(sportId));
	    	return "editsport";
	    }
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveEdit(Sport sport){
	        sportRepo.save(sport);
	        return "redirect:sportlist"; 
	    }
}
