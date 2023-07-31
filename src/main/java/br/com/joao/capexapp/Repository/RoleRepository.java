package br.com.joao.capexapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.capexapp.Entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {

  Roles findById(long id);
}
