package br.com.joao.capexapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.joao.capexapp.Entity.LoginForm;
import br.com.joao.capexapp.Entity.User;
import br.com.joao.capexapp.Repository.UserRepository;
import br.com.joao.capexapp.Services.PasswordService;
import br.com.joao.capexapp.Services.UserService;

@RestController
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordService passwordService;

  @PostMapping("/singup")
  public ResponseEntity<String> singup(@RequestBody User user) {
    String passowrdEncrypted = userService.saveUserWithEncryptedPassword(user);
    user.setPassword(passowrdEncrypted);
    userRepository.save(user);
    return ResponseEntity.ok("User created");
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginForm loginForm) {

    boolean isValid = passwordService.checkPassword(loginForm.getPassword(), loginForm.getLogin());

    if (isValid) {
      return ResponseEntity.status(HttpStatus.OK).body("User logged");
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
  }

  @PostMapping("/logout")
  public ResponseEntity<String> logout() {
    return ResponseEntity.ok("User logged out");
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> users() {
    List<User> users = userRepository.findAll();
    return ResponseEntity.status(200).body(users);
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable Long id) {
    return userRepository.findById(id).map(record -> {
      record.setLogin(user.getLogin());
      record.setPassword(userService.saveUserWithEncryptedPassword(user));
      User updated = userRepository.save(record);
      System.out.println(updated);
      return ResponseEntity.ok().body("User updated");
    }).orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    userRepository.delete(userRepository.findById(id).get());
    return ResponseEntity.ok("User deleted");
  }
}
