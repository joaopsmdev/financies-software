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

  /* GET TODOS SUBS PROJETOS */
  public List<Subprojeto> getSubProjeto() {
    List<Subprojeto> subProjeto = subProjetoRepository.findAll();
    return subProjeto;
  }

  /* GET SUB PROJETO POR ID */
  public Subprojeto getSubProjetoById(Long id) {
    Subprojeto subProjeto = subProjetoRepository.findById(id).get();
    return subProjeto;
  }

  /* SAVE SUB PROJETO */
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

  /* PUT SUB PROJETO */
  public Subprojeto putSubProjeto(Long id, Subprojeto subProjeto) {
    /* Pega projeto pelo id */
    Subprojeto putSubProjeto = subProjetoRepository.findById(id).get();

    /* Seta os valores do projeto */
    putSubProjeto.setNomeSubprojeto(subProjeto.getNomeSubprojeto());
    putSubProjeto.setValorVerba(subProjeto.getValorVerba());
    putSubProjeto.setValorRealizado(subProjeto.getValorRealizado());

    /* Verifica se o valor disponivel é maior que o valor realizado */
    if (putSubProjeto.getValorDisponivel() != null
        && putSubProjeto.getValorDisponivel() >= subProjeto.getValorRealizado()) {
      putSubProjeto.setValorDisponivel(putSubProjeto.getValorVerba() - putSubProjeto.getValorRealizado());
    } else {
      putSubProjeto.setValorDisponivel(putSubProjeto.getValorVerba());
    }
    saveSubProjeto(putSubProjeto);
    return putSubProjeto;
  }

  public String deleteSubProjeto(Long id) {
    Subprojeto subProjeto = subProjetoRepository.findById(id).get();
    subProjetoRepository.delete(subProjeto);
    return "SubProjeto deletado com sucesso!";
  }

}
