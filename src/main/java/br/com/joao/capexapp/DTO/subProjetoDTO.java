package br.com.joao.capexapp.DTO;

public class subProjetoDTO {

  public subProjetoDTO(long subprojeto_id, String nomeSubprojeto, Integer numeroSubprojeto, Long valorVerba,
      Long valorRealizado, Long valorComprometido, Long valorDisponivel, Long valorTendencia) {
    this.subprojeto_id = subprojeto_id;
    this.nomeSubprojeto = nomeSubprojeto;
    this.numeroSubprojeto = numeroSubprojeto;
    this.valorVerba = valorVerba;
    this.valorRealizado = valorRealizado;
    this.valorComprometido = valorComprometido;
    this.valorDisponivel = valorDisponivel;
    this.valorTendencia = valorTendencia;
  }

  private long subprojeto_id;

  private String nomeSubprojeto;

  private Integer numeroSubprojeto;

  private Long valorVerba;

  private Long valorRealizado;

  private Long valorComprometido;

  private Long valorDisponivel;

  private Long valorTendencia;

  public long getSubprojeto_id() {
    return subprojeto_id;
  }

  public String getNomeSubprojeto() {
    return nomeSubprojeto;
  }

  public Integer getNumeroSubprojeto() {
    return numeroSubprojeto;
  }

  public Long getValorVerba() {
    return valorVerba;
  }

  public Long getValorRealizado() {
    return valorRealizado;
  }

  public Long getValorComprometido() {
    return valorComprometido;
  }

  public Long getValorDisponivel() {
    return valorDisponivel;
  }

  public Long getValorTendencia() {
    return valorTendencia;
  }
}
