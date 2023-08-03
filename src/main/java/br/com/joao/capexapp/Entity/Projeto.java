package br.com.joao.capexapp.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

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
  private long projetoId;

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
  private Double valorVerba;

  @Column(nullable = true)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Double valorVerbaComprometida;

  @Column(nullable = true)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Double valorRealizado;

  @Column(nullable = true)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Double valorSaldo;

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
    return projetoId;
  }

  public void setProjeto_id(long projeto_id) {
    this.projetoId = projeto_id;
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

  public Double getValorVerba() {
    return valorVerba;
  }

  public void setValorVerba(Double valorVerba) {
    this.valorVerba = valorVerba;
  }

  public Double getValorRealizado() {
    return valorRealizado;
  }

  public void setValorRealizado(Double valorRealizado) {
    this.valorRealizado = valorRealizado;
  }

  public Double getValorSaldo() {
    return valorSaldo;
  }

  public void setValorSaldo(Double valorSaldo) {
    this.valorSaldo = valorSaldo;
  }

  public Double getValorVerbaComprometida() {
    return valorVerbaComprometida;
  }

  public void setValorVerbaComprometida(Double valorVerbaComprometida) {
    this.valorVerbaComprometida = valorVerbaComprometida;
  }
}
