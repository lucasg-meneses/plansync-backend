package br.com.lucasgmeneses.plansync.repository;

import br.com.lucasgmeneses.plansync.domain.model.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoModel, String> {

}
