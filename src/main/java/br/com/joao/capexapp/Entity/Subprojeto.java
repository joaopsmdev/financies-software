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
  private Double valorVerba;

  @Column(nullable = true)
  private Double valorRealizado;

  public Double getValorRealizado() {
    return valorRealizado;
  }

  public void setValorRealizado(Double valorRealizado) {
    this.valorRealizado = valorRealizado;
  }

  @Column(nullable = true)
  private Double valorComprometido;

  public Double getValorComprometido() {
    return valorComprometido;
  }

  public void setValorComprometido(Double valorComprometido) {
    this.valorComprometido = valorComprometido;
  }

  @Column(nullable = true)
  private Double valorDisponivel;

  public Double getValorDisponivel() {
    return valorDisponivel;
  }

  public void setValorDisponivel(Double valorDisponivel) {
    this.valorDisponivel = valorDisponivel;
  }

  @Column(nullable = true)
  private Double valorTendencia;

  public Double getValorTendencia() {
    return valorTendencia;
  }

  public void setValorTendencia(Double valorTendencia) {
    this.valorTendencia = valorTendencia;
  }

  @ManyToOne
  @JoinColumn(name = "projetoId", nullable = false)
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

  public Double getValorVerba() {
    return valorVerba;
  }

  public void setValorVerba(Double valorVerba) {
    this.valorVerba = valorVerba;
  }

}
