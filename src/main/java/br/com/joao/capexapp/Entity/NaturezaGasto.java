package br.com.joao.capexapp.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "naturezagasto")
public class NaturezaGasto {

  public NaturezaGasto() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long naturezaId;

  @Column(nullable = false, unique = true)
  private String codigo;

  @Column(nullable = false)
  private String descricao;

  @OneToMany(mappedBy = "naturezaGasto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Item> item = new ArrayList<>();

  public List<Item> getItem() {
    return item;
  }

  public void setItem(List<Item> item) {
    this.item = item;
  }

  @ManyToOne
  @JoinColumn(name = "subprojeto_id", nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private Subprojeto subprojeto;

  public Subprojeto getSubprojeto() {
    return subprojeto;
  }

  public void setSubprojeto(Subprojeto subprojeto) {
    this.subprojeto = subprojeto;
  }

  public NaturezaGasto(String codigo, String descricao) {
    this.codigo = codigo;
    this.descricao = descricao;
  }

  public NaturezaGasto(String codigo) {
    this.codigo = codigo;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
