package br.com.lucasgmeneses.plansync.repository;

import br.com.lucasgmeneses.plansync.model.PlannerModel;
import br.com.lucasgmeneses.plansync.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlannerRepository extends JpaRepository<PlannerModel,Long>{
    List<PlannerModel> findAllByUser(UserModel user);
}
