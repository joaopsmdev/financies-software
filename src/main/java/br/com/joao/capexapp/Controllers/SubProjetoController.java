package br.com.joao.capexapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.capexapp.Entity.Subprojeto;
import br.com.joao.capexapp.Services.SubProjetoService;

@RestController
public class SubProjetoController {

  @Autowired
  private SubProjetoService subProjetoService;

  @GetMapping("/subprojeto")
  public List<Subprojeto> get() {
    return subProjetoService.getSubProjeto();
  }

  @PostMapping("/subprojeto")
  public Subprojeto save(@RequestBody Subprojeto subProjeto) {
    return subProjetoService.saveSubProjeto(subProjeto);
  }

}
