package br.com.joao.capexapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.capexapp.Entity.NaturezaGasto;

public interface NaturezaGastoRepository extends JpaRepository<NaturezaGasto, Long> {
}
