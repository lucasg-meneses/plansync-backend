package br.com.lucasgmeneses.plansync.controller;

import br.com.lucasgmeneses.plansync.model.PlannerModel;
import br.com.lucasgmeneses.plansync.model.UserModel;
import br.com.lucasgmeneses.plansync.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlannerController {
    @Autowired
    private PlannerRepository plannerRepository;
    @GetMapping("/planners")
    public List<PlannerModel> getAllPlannerByUser(){
        return plannerRepository.findAllByUser(new UserModel());

    }

}
