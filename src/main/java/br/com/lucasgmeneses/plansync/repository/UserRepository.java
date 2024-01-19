package br.com.lucasgmeneses.plansync.repository;

import br.com.lucasgmeneses.plansync.domain.model.PlannerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<PlannerModel,String> {

}
