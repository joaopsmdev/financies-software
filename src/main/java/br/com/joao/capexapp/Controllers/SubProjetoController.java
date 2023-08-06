package br.com.joao.capexapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.capexapp.Entity.Subprojeto;
import br.com.joao.capexapp.Services.SubProjetoService;

@RestController
public class SubProjetoController {

  @Autowired
  private SubProjetoService subProjetoService;

  @GetMapping("/subprojeto")
  public ResponseEntity<List<Subprojeto>> get() {
    List<Subprojeto> subprojeto = subProjetoService.getSubProjeto();
    return ResponseEntity.status(200).body(subprojeto);
  }

  @GetMapping("/subprojeto/{id}")
  public ResponseEntity<Subprojeto> getSubProjetobyId(@PathVariable Long id) {
    Subprojeto subProjeto = subProjetoService.getSubProjetoById(id);
    return ResponseEntity.status(200).body(subProjeto);
  }

  @PostMapping("/subprojeto")
  public ResponseEntity<Subprojeto> save(@RequestBody Subprojeto subProjeto) {
    subProjetoService.saveSubProjeto(subProjeto);
    return ResponseEntity.status(201).body(subProjeto);
  }

  @PutMapping("/subprojeto/{id}")
  public ResponseEntity<Subprojeto> put(@PathVariable Long id, @RequestBody Subprojeto subProjeto) {
    subProjetoService.putSubProjeto(id, subProjeto);
    return ResponseEntity.status(201).body(subProjeto);
  }

  @DeleteMapping("/subprojeto/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id) {
    subProjetoService.deleteSubProjeto(id);
    return ResponseEntity.status(200).body("SubProjeto deletado com sucesso!");
  }

}
