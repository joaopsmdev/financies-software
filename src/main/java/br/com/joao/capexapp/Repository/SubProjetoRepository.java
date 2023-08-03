package br.com.joao.capexapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.capexapp.Entity.Subprojeto;

public interface SubProjetoRepository extends JpaRepository<Subprojeto, Long> {

  List<Subprojeto> findByProjetoProjetoId(Long projetoId);
}
