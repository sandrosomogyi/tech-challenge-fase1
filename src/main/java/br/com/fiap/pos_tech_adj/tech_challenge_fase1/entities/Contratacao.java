package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_Contratacao")
public class Contratacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContratacao;
    private Vaga vaga;
    private Colaborador colaborador;
    private Candidato candidato;
    private Date dataInicio;
    private Date dataFim;
    private boolean validado;

    // Construtor
    public Contratacao(Long idContratacao, Vaga vaga, Colaborador colaborador, Candidato candidato,
                       Date dataInicio, Date dataFim, boolean validado) {
        this.idContratacao = idContratacao;
        this.vaga = vaga;
        this.colaborador = colaborador;
        this.candidato = candidato;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.validado = validado;
    }

    // Getters e Setters
    public Long getIdContratacao() {
        return idContratacao;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
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
