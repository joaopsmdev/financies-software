package br.com.joao.capexapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.capexapp.Entity.Roles;
import br.com.joao.capexapp.Repository.RoleRepository;

@RestController
public class RolesController {

  @Autowired
  private RoleRepository roleRepository;

  @PostMapping("/roles")
  public ResponseEntity<String> roles(@RequestBody Roles roles) {
    String name = roles.getName();
    roles.setName(name);
    roleRepository.save(roles);
    return ResponseEntity.status(201).body("Role created");
  }
}
