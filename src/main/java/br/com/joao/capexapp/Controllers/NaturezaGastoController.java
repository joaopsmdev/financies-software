package br.com.joao.capexapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.capexapp.Entity.NaturezaGasto;
import br.com.joao.capexapp.Services.NaturezaGastoService;

@RestController
public class NaturezaGastoController {
  @Autowired
  private NaturezaGastoService naturezaGastoService;

  @GetMapping("/naturezagasto")
  public ResponseEntity<List<NaturezaGasto>> get() {
    List<NaturezaGasto> naturezaGastos = naturezaGastoService.findAll();
    return ResponseEntity.status(200).body(naturezaGastos);
  }

  @PostMapping("/naturezagasto")
  public ResponseEntity<NaturezaGasto> post(@RequestBody NaturezaGasto naturezaGasto) {
    NaturezaGasto naturezaGastoSalvo = naturezaGastoService.save(naturezaGasto);
    return ResponseEntity.status(201).body(naturezaGastoSalvo);
  }

  public ResponseEntity<NaturezaGasto> put(@RequestBody Long id, NaturezaGasto naturezaGasto) {
    NaturezaGasto naturezaGastoSalvo = naturezaGastoService.update(id, naturezaGasto);
    return ResponseEntity.status(201).body(naturezaGastoSalvo);
  }

  public ResponseEntity<String> delete(@RequestBody Long id) {
    naturezaGastoService.delete(id);
    return ResponseEntity.status(204).body("Natureza Deleteada com sucesso");
  }
}
