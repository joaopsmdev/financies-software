package br.com.joao.capexapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.capexapp.Entity.NaturezaGasto;
import br.com.joao.capexapp.Repository.NaturezaGastoRepository;

@Service
public class NaturezaGastoService {

  @Autowired
  private NaturezaGastoRepository naturezaGastoRepository;

  public List<NaturezaGasto> findAll() {
    return naturezaGastoRepository.findAll();
  }

  public NaturezaGasto findById(Long id) {
    return naturezaGastoRepository.findById(id).get();
  }

  public NaturezaGasto save(NaturezaGasto naturezaGasto) {
    return naturezaGastoRepository.save(naturezaGasto);
  }

  public NaturezaGasto update(Long id, NaturezaGasto naturezaGasto) {
    NaturezaGasto naturezaGastoUpdate = naturezaGastoRepository.findById(id).get();
    naturezaGastoUpdate.setDescricao(naturezaGasto.getDescricao());
    naturezaGastoUpdate.setCodigo(naturezaGasto.getCodigo());
    return naturezaGastoRepository.save(naturezaGastoUpdate);

  }

  public void delete(Long id) {
    naturezaGastoRepository.deleteById(id);
  }
}
