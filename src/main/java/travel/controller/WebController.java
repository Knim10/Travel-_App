
package travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import travel.beans.*;
import travel.repository.ITravelRepo;

@Controller
public class WebController {
	// Auto wiring CRUD capabilities from JPA repository/ITravelRepo
	@Autowired
	ITravelRepo repo;

	// This method will direct to add.html from results/index
	@GetMapping("/addDestination")
	public String add(Model model) {
		Destination d = new Destination();
		model.addAttribute("newDestination", d);
		return "addDestination";
	}

	// This method will be used in add.html template, to add entities into DB
	@PostMapping("/addDestination")
	public String add(@ModelAttribute Destination d, Model model) {
		repo.save(d);
		return viewDestinations(model);
	}

	// This method is used to update/edit existing entities
	@GetMapping("/editDestination/{id}")
	public String showUpdate(@PathVariable("id") long id, Model model) {
		Destination d = repo.findById(id).orElse(null);
		model.addAttribute("newDestination", d);
		return "addDestination.html";
	}

	// This method is used to delete existing entities
	@GetMapping("/deleteDestination/{id}")
	public String delete(@PathVariable("id") long id, Model model) {
		Destination d = repo.findById(id).orElse(null);
		System.out.println(d);
		repo.delete(d);
		return viewDestinations(model);
	}

	// This method is used within the addDestination.html
	@PostMapping("/updateDestination/{id}")
	public String getUpdate(Destination d, Model model) {
		repo.save(d);
		return viewDestinations(model);
	}

	// This method is used to show all existing entities within the /add method
	@GetMapping({ "/", "viewAllDestinations" })
	public String viewDestinations(Model model) {
		if (repo.findAll().isEmpty()) {
			return add(model);
		}
		model.addAttribute("Destination", repo.findAll());
		return "showDestinations";
	}

	// This method is used to show all existing entities within the /add method
	@GetMapping({"viewAllDestinations#byPrice" })
	public String orderDestinationsByPrice(Model model) {
		if (repo.findAll().isEmpty()) {
			return add(model);
		}
		model.addAttribute("Destination", repo.findAll());
		return "showDestinations";
	}


}