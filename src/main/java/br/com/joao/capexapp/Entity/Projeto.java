package br.com.joao.capexapp.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto")
public class Projeto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long projeto_id;

  @Column(nullable = false, unique = true)
  private Integer numeroProjeto;

  @Column(nullable = false)
  private String nomeProjeto;

  @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Subprojeto> subprojeto = new ArrayList<>();

  public List<Subprojeto> getSubprojeto() {
    return subprojeto;
  }

  public void setSubprojeto(List<Subprojeto> subprojeto) {
    this.subprojeto = subprojeto;
  }

  @Column(nullable = false)
  private Long valorVerba;

  @Column(nullable = true)
  private Long valorRealizado;

  @Column(nullable = true)
  private Long valorSaldo;

  @ManyToMany
  @Column(nullable = true)
  private Set<User> users;

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public long getProjeto_id() {
    return projeto_id;
  }

  public void setProjeto_id(long projeto_id) {
    this.projeto_id = projeto_id;
  }

  public Integer getNumeroProjeto() {
    return numeroProjeto;
  }

  public void setNumeroProjeto(Integer numeroProjeto) {
    this.numeroProjeto = numeroProjeto;
  }

  public String getNomeProjeto() {
    return nomeProjeto;
  }

  public void setNomeProjeto(String nomeProjeto) {
    this.nomeProjeto = nomeProjeto;
  }

  public Long getValorVerba() {
    return valorVerba;
  }

  public void setValorVerba(Long valorVerba) {
    this.valorVerba = valorVerba;
  }

  public Long getValorRealizado() {
    return valorRealizado;
  }

  public void setValorRealizado(Long valorRealizado) {
    this.valorRealizado = valorRealizado;
  }

  public Long getValorSaldo() {
    return valorSaldo;
  }

  public void setValorSaldo(Long valorSaldo) {
    this.valorSaldo = valorSaldo;
  }

}
