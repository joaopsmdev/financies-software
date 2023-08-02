package br.com.joao.capexapp.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subprojeto")
public class Subprojeto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long subprojeto_id;

  @Column(nullable = false, unique = true)
  private String nomeSubprojeto;

  @Column(nullable = false, unique = true)
  private Integer numeroSubprojeto;

  @Column(nullable = false)
  private Long valorVerba;

  @Column(nullable = true)
  private Long valorRealizado;

  @Column(nullable = true)
  private Long valorComprometido;

  @Column(nullable = true)
  private Long valorDisponivel;

  @Column(nullable = true)
  private Long valorTendencia;

  @ManyToOne
  @JoinColumn(name = "projeto_id", nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Projeto projeto;

  public Projeto getProjeto() {
    return projeto;
  }

  public void setProjeto(Projeto projeto) {
    this.projeto = projeto;
  }

  public long getSubprojeto_id() {
    return subprojeto_id;
  }

  public void setSubprojeto_id(long subprojeto_id) {
    this.subprojeto_id = subprojeto_id;
  }

  public String getNomeSubprojeto() {
    return nomeSubprojeto;
  }

  public void setNomeSubprojeto(String nomeSubprojeto) {
    this.nomeSubprojeto = nomeSubprojeto;
  }

  public Integer getNumeroSubprojeto() {
    return numeroSubprojeto;
  }

  public void setNumeroSubprojeto(Integer numeroSubprojeto) {
    this.numeroSubprojeto = numeroSubprojeto;
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

  public Long getValorComprometido() {
    return valorComprometido;
  }

  public void setValorComprometido(Long valorComprometido) {
    this.valorComprometido = valorComprometido;
  }

  public Long getValorDisponivel() {
    return valorDisponivel;
  }

  public void setValorDisponivel(Long valorDisponivel) {
    this.valorDisponivel = valorDisponivel;
  }

  public Long getValorTendencia() {
    return valorTendencia;
  }

  public void setValorTendencia(Long valorTendencia) {
    this.valorTendencia = valorTendencia;
  }
}
