package com.mhsl.spring;

import com.mhsl.spring.model.UserEntity;
import com.mhsl.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {
	
	private UserService personService;
	private int page = 0, pageCount;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(UserService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new UserEntity());
		model.addAttribute("listPersons", personService.listPersons(page));
		model.addAttribute("page", page);
		pageCount = personService.listPersons().size() / 10 +
				((personService.listPersons().size() % 10 > 0) ? 1 : 0);
		model.addAttribute("pageCount", pageCount);
		return "person";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("searchQuery") String searchQuery, Model model) {
		model.addAttribute("person", new UserEntity());
		model.addAttribute("listPersons", personService.listPersonsWithName(searchQuery, page));
		model.addAttribute("page", page);
		pageCount = personService.getPersonsByName(searchQuery).size() / 10 +
				((personService.getPersonsByName(searchQuery).size() % 10 > 0) ? 1 : 0);
		model.addAttribute("pageCount", pageCount);
		return "person";
	}
	
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") UserEntity person){
		if(person.getId() == 0){
			personService.addPerson(person);
		} else{
			personService.updatePerson(person);
		}
		return "redirect:/person";
	}

	@RequestMapping(value= "/person/prev", method = RequestMethod.POST)
	public String prevPage(){
		page--;
		if (page < 0) page = 0;
		return "redirect:/person";
	}
	
	@RequestMapping(value= "/person/next", method = RequestMethod.POST)
	public String nextPage(){
		page++;
		if (page > pageCount)  page--;
		return "redirect:/person";
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        personService.removePerson(id);
        return "redirect:/person";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personService.getPersonById(id));
        model.addAttribute("listPersons", personService.listPersons());
        return "person";
    }
	
}
