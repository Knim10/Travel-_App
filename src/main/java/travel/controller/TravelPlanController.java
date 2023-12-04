package travel.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.beans.TravelPlan;
import travel.service.TravelPlanService;

@Controller
@RequestMapping("/travel-plans")
public class TravelPlanController {

    @Autowired
    private TravelPlanService travelPlanService;

    @GetMapping
    public List<TravelPlan> getAllTravelPlans() {
        return travelPlanService.getAllTravelPlans();
    }

    @GetMapping("/{id}")
    public TravelPlan getTravelPlanById(@PathVariable Long id) {
        return travelPlanService.getTravelPlanById(id);
    }

    @GetMapping("/view")
    public String viewTravelPlans(Model model) {
        List<TravelPlan> travelPlans = travelPlanService.getAllTravelPlans();
        model.addAttribute("travelPlans", travelPlans);
        return "view-travel-plans";
    }

    @PostMapping("/update-access")
    public String updateAccess(@RequestParam("planIds") List<Long> planIds,
                               @RequestParam("accessType") String accessType,
                               @RequestParam("newUsers") List<String> newUsers) {
        travelPlanService.updateAccess(planIds, accessType, newUsers);
        return "redirect:/travel-plans/view";
    }

    @GetMapping("/editTravelPlan/{id}")
    public String updateTravelPlan(@PathVariable("id") Long id, Model model){
    TravelPlan t = travelPlanService.getTravelPlanById(id);
    model.addAttribute("travelPlan", t);
    return "view-travel-plans.html";
    }

    @GetMapping("/deleteTravelPlan/{id}")
    public String deleteTravelPlan(@PathVariable("id") Long id, Model model) {
        travelPlanService.deleteTravelPlan(id);
        return viewTravelPlans(model);
    }

}
