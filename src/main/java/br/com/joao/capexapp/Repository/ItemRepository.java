package br.com.joao.capexapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.capexapp.Entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
