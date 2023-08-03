package br.com.joao.capexapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.capexapp.Entity.Subprojeto;
import br.com.joao.capexapp.Repository.ProjetoRepository;
import br.com.joao.capexapp.Repository.SubProjetoRepository;

@Service
public class SubProjetoService {
  @Autowired
  private SubProjetoRepository subProjetoRepository;

  @Autowired
  ProjetoRepository projetoRepository;

  @Autowired
  ProjetoService projetoService;

  public List<Subprojeto> getSubProjeto() {
    List<Subprojeto> subProjeto = subProjetoRepository.findAll();
    return subProjeto;
  }

  public Subprojeto saveSubProjeto(Subprojeto subProjeto) {
    if (subProjeto.getValorRealizado() == null) {
      subProjeto.setValorRealizado(0.0);
    } else {
      subProjeto.setValorRealizado(subProjeto.getValorRealizado());
    }
    subProjeto.setValorDisponivel(subProjeto.getValorVerba() - subProjeto.getValorRealizado());
    Subprojeto subProjetos = subProjetoRepository.save(subProjeto);
    return subProjetos;
  }

}
