package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_Bonificacao")
public class Bonificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBonificacao;
    private Vaga vaga;
    private Colaborador colaborador;
    private Candidato candidato;
    private Contratacao contratacao;
    private Date dataBonificacao;
    private boolean efetuada;

    // Construtor
    public Bonificacao(Long idBonificacao, Vaga vaga, Colaborador colaborador, Candidato candidato,
                       Contratacao contratacao, Date dataBonificacao, boolean efetuada) {
        this.idBonificacao = idBonificacao;
        this.vaga = vaga;
        this.colaborador = colaborador;
        this.candidato = candidato;
        this.contratacao = contratacao;
        this.dataBonificacao = dataBonificacao;
        this.efetuada = efetuada;
    }

    // Getters e Setters
    public Long getIdBonificacao() {
        return idBonificacao;
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

    public Contratacao getContratacao() {
        return contratacao;
    }

    public void setContratacao(Contratacao contratacao) {
        this.contratacao = contratacao;
    }

    public Date getDataBonificacao() {
        return dataBonificacao;
    }

    public void setDataBonificacao(Date dataBonificacao) {
        this.dataBonificacao = dataBonificacao;
    }

    public boolean isEfetuada() {
        return efetuada;
    }

    public void setEfetuada(boolean efetuada) {
        this.efetuada = efetuada;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Bonificacao{" +
                "idBonificacao=" + idBonificacao +
                ", vaga=" + vaga +
                ", colaborador=" + colaborador +
                ", candidato=" + candidato +
                ", contratacao=" + contratacao +
                ", dataBonificacao=" + dataBonificacao +
                ", efetuada=" + efetuada +
                '}';
    }
}
