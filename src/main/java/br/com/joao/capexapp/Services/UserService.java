package br.com.joao.capexapp.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.joao.capexapp.Entity.User;

@Service
public class UserService {

  @Autowired
  private PasswordService passwordEncoder;

  public String saveUserWithEncryptedPassword(User users) {
    String encryptedPassword = passwordEncoder.encryptPassword(users.getPassword());
    return encryptedPassword;
  }
}
