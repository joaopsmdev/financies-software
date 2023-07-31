package br.com.joao.capexapp.Services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joao.capexapp.Entity.User;
import br.com.joao.capexapp.Repository.UserRepository;

@Service
public class PasswordService {
  @Autowired
  private UserRepository userRepository;

  public String encryptPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

  public boolean checkPassword(String password, String username) {
    User resultado = userRepository.findByLogin(username);
    if (resultado == null) {
      return false;
    } else {
      return BCrypt.checkpw(password, resultado.getPassword());
    }
  }
}
