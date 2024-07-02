package br.com.lucasgmeneses.plansync.repository;

import br.com.lucasgmeneses.plansync.domain.model.PlannerModel;
import br.com.lucasgmeneses.plansync.domain.model.TodoModel;
import br.com.lucasgmeneses.plansync.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
@Repository
public interface TodoRepository extends JpaRepository<TodoModel, String> {
    List<TodoModel> findByPlanner(PlannerModel planner);
    List<TodoModel> findAllByOwnerAndPlannerId(UserDetails user, String idPlanner);
}
