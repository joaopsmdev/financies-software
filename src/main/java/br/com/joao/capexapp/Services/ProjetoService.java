package br.com.joao.capexapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.capexapp.Entity.Projeto;
import br.com.joao.capexapp.Repository.ProjetoRepository;

@Service
public class ProjetoService {

  @Autowired
  private ProjetoRepository projetoRepository;

  public Projeto saveProjeto(Projeto projeto) {
    Projeto projetos = projetoRepository.save(projeto);
    return projetos;
  }

  public List<Projeto> getProjeto() {
    List<Projeto> projeto = projetoRepository.findAll();
    projeto.forEach(p -> p.setValorSaldo(p.getValorVerba()));
    projeto.forEach(p -> p.setValorRealizado(Long.valueOf(0)));
    return projeto;
  }
}
