package br.com.joao.capexapp.Utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.capexapp.Entity.Projeto;
import br.com.joao.capexapp.Entity.Subprojeto;
import br.com.joao.capexapp.Repository.ProjetoRepository;
import br.com.joao.capexapp.Repository.SubProjetoRepository;

@Service
public class utilsValores {
  @Autowired
  private ProjetoRepository projetoRepository;

  @Autowired
  private SubProjetoRepository subProjetoRepository;

  public void atualizaValoresProjeto(Long projetoId) {
    Projeto projeto = projetoRepository.findById(projetoId)
        .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

    Double valorRealizado = 0.0;
    Double verbaComprometida = 0.0;
    List<Subprojeto> subprojetos = subProjetoRepository.findByProjetoProjetoId(projetoId);
    for (Subprojeto subprojeto : subprojetos) {
      valorRealizado += subprojeto.getValorRealizado();
      verbaComprometida += subprojeto.getValorVerba();
    }

    projeto.setValorRealizado(valorRealizado);
    projeto.setValorSaldo(projeto.getValorVerba() - projeto.getValorRealizado());
    projeto.setValorVerbaComprometida(projeto.getValorVerba() - verbaComprometida);

    projetoRepository.save(projeto);
  }
}
