package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_Vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVaga;
    private String titulo;
    private String descricao;
    private String requisitosObrigatorios;
    private String requisitosDesejaveis;
    private String beneficios;
    private String tipoContratacao;
    private Double remuneracao;
    private Double valorBonificacao;
    private String observacoes;

    // Construtor
    public Vaga(Long idVaga, String titulo, String descricao, String requisitosObrigatorios,
                String requisitosDesejaveis, String beneficios, String tipoContratacao,
                Double remuneracao, Double valorBonificacao, String observacoes) {
        this.idVaga = idVaga;
        this.titulo = titulo;
        this.descricao = descricao;
        this.requisitosObrigatorios = requisitosObrigatorios;
        this.requisitosDesejaveis = requisitosDesejaveis;
        this.beneficios = beneficios;
        this.tipoContratacao = tipoContratacao;
        this.remuneracao = remuneracao;
        this.valorBonificacao = valorBonificacao;
        this.observacoes = observacoes;
    }

    // Getters e Setters
    public Long getIdVaga() {
        return idVaga;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequisitosObrigatorios() {
        return requisitosObrigatorios;
    }

    public void setRequisitosObrigatorios(String requisitosObrigatorios) {
        this.requisitosObrigatorios = requisitosObrigatorios;
    }

    public String getRequisitosDesejaveis() {
        return requisitosDesejaveis;
    }

    public void setRequisitosDesejaveis(String requisitosDesejaveis) {
        this.requisitosDesejaveis = requisitosDesejaveis;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(String tipoContratacao) {
        this.tipoContratacao = tipoContratacao;
    }

    public Double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(Double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public Double getValorBonificacao() {
        return valorBonificacao;
    }

    public void setValorBonificacao(Double valorBonificacao) {
        this.valorBonificacao = valorBonificacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Vaga{" +
                "idVaga=" + idVaga +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", requisitosObrigatorios='" + requisitosObrigatorios + '\'' +
                ", requisitosDesejaveis='" + requisitosDesejaveis + '\'' +
                ", beneficios='" + beneficios + '\'' +
                ", tipoContratacao='" + tipoContratacao + '\'' +
                ", remuneracao=" + remuneracao +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}