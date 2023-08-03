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
    if (projeto.getValorRealizado() == null) {
      projeto.setValorRealizado(0.0);
    } else {
      projeto.setValorRealizado(projeto.getValorRealizado());
    }
    projeto.setValorSaldo(projeto.getValorVerba() - projeto.getValorRealizado());
    Projeto projetos = projetoRepository.save(projeto);
    return projetos;
  }

  public Projeto getProjetoById(Long id) {
    Projeto projeto = projetoRepository.findById(id).get();
    return projeto;
  }

  public List<Projeto> getProjeto() {
    List<Projeto> projeto = projetoRepository.findAll();
    return projeto;
  }

  public Projeto putProjeto(Long id, Projeto projeto) {
    Projeto putProjeto = projetoRepository.findById(id).get();
    putProjeto.setNomeProjeto(projeto.getNomeProjeto());
    putProjeto.setValorVerba(projeto.getValorVerba());
    putProjeto.setValorRealizado(projeto.getValorRealizado());
    if (putProjeto.getValorSaldo() != null) {
      putProjeto.setValorSaldo(putProjeto.getValorVerba() - putProjeto.getValorRealizado());
    } else {
      putProjeto.setValorSaldo(putProjeto.getValorVerba());
    }
    saveProjeto(putProjeto);
    return putProjeto;
  }

  public void deleteProjeto(Long id) {
    Projeto projeto = projetoRepository.findById(id).get();
    projetoRepository.delete(projeto);
  }
}
