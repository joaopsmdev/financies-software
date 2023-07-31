package br.com.joao.capexapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.capexapp.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByLogin(String login);

  User findById(long id);
}
