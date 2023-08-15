package br.com.joao.capexapp.Entity;

import java.sql.Date;

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
@Table(name = "item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long itemId;

  @Column(nullable = false, unique = true)
  private String codigo;

  @Column(nullable = false)
  private String descricao;

  @Column(nullable = false)
  private Double valorRealizado;

  @Column(nullable = false)
  private Date dataRealizado;

  @ManyToOne
  @JoinColumn(name = "naturezaId", nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private NaturezaGasto naturezaGasto;

  public NaturezaGasto getNaturezaGasto() {
    return naturezaGasto;
  }

  public void setNaturezaGasto(NaturezaGasto naturezaGasto) {
    this.naturezaGasto = naturezaGasto;
  }

  public long getItemId() {
    return itemId;
  }

  public void setItemId(long itemId) {
    this.itemId = itemId;
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

  public Double getValorRealizado() {
    return valorRealizado;
  }

  public void setValorRealizado(Double valorRealizado) {
    this.valorRealizado = valorRealizado;
  }

  public Date getDataRealizado() {
    return dataRealizado;
  }

  public void setDataRealizado(Date dataRealizado) {
    this.dataRealizado = dataRealizado;
  }

}
