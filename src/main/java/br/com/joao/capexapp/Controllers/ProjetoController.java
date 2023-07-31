package br.com.joao.capexapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.capexapp.Entity.Projeto;
import br.com.joao.capexapp.Services.ProjetoService;

@RestController
public class ProjetoController {

  @Autowired
  private ProjetoService projetoService;

  @GetMapping("/projeto")
  public ResponseEntity<List<Projeto>> get() {
    return ResponseEntity.ok(projetoService.getProjeto());
  }

  @PostMapping("/projeto")
  public ResponseEntity<Projeto> save(@RequestBody Projeto projeto) {
    return ResponseEntity.ok(projetoService.saveProjeto(projeto));
  }
}
