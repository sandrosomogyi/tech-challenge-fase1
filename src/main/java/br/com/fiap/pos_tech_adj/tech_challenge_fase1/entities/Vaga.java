package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_Vaga")
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

    // Contrutor Padrão
    public Vaga() {
    }

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