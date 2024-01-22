package br.com.lucasgmeneses.plansync.repository;

import br.com.lucasgmeneses.plansync.domain.model.PlannerModel;
import br.com.lucasgmeneses.plansync.domain.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoModel, String> {
    List<TodoModel> findByPlanner(PlannerModel planner);
}
