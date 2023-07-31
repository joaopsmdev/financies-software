package br.com.joao.capexapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.capexapp.Entity.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
