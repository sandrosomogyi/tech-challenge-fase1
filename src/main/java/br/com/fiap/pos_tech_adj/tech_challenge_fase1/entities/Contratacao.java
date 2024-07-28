package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_Contratacao")
public class Contratacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContratacao;

    @OneToOne
    @JoinColumn(name = "idVaga")
    private Vaga vaga;

    @OneToOne
    @JoinColumn(name = "idColaborador")
    private Colaborador colaborador;

    @OneToOne
    @JoinColumn(name = "idCandidato")
    private Candidato candidato;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean validado;

    // Contrutor Padrão
    public Contratacao() {
    }

    // Construtor
    public Contratacao(Long idContratacao, Vaga vaga, Colaborador colaborador, Candidato candidato,
            LocalDate dataInicio, LocalDate dataFim, boolean validado) {
        this.idContratacao = idContratacao;
        this.vaga = vaga;
        this.colaborador = colaborador;
        this.candidato = candidato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.validado = validado;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Contratacao{" +
                "idContratacao=" + idContratacao +
                ", vaga=" + vaga +
                ", colaborador=" + colaborador +
                ", candidato=" + candidato +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", validado=" + validado +
                '}';
    }
}
