package br.com.lucasgmeneses.plansync.repository;

import br.com.lucasgmeneses.plansync.domain.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserModel,String> {
    UserDetails findByLogin(String login);
    UserDetails findByEmail(String email);
}
