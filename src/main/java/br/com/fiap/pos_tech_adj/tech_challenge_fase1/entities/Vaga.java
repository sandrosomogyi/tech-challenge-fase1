package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String requisitosObrigatorios;
    private String requisitosDesejaveis;
    private String beneficios;
    private String tipoContratacao;
    private Double remuneracao;
    private Double valorBonificacao;
    private String observacoes;
    private Boolean finalizada;
    private LocalDate dataVaga;

    @OneToMany(mappedBy = "vaga")
    @JsonManagedReference(value = "vaga-indicacao")
    private List<Indicacao> indicacoes;

    // Contrutor Padrão
    public Vaga() {
    }

    // Construtor
    public Vaga(Long id, String titulo, String descricao, String requisitosObrigatorios,
            String requisitosDesejaveis, String beneficios, String tipoContratacao,
            Double remuneracao, Double valorBonificacao, String observacoes, Boolean finalizada, LocalDate dataVaga, List<Indicacao> indicacoes) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.requisitosObrigatorios = requisitosObrigatorios;
        this.requisitosDesejaveis = requisitosDesejaveis;
        this.beneficios = beneficios;
        this.tipoContratacao = tipoContratacao;
        this.remuneracao = remuneracao;
        this.valorBonificacao = valorBonificacao;
        this.observacoes = observacoes;
        this.finalizada = finalizada;
        this.dataVaga = dataVaga;
        this.indicacoes = indicacoes;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Vaga{" +
                "id=" + id +
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