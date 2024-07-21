package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_Indicacao")
public class Indicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIndicacao;
    private Vaga vaga;
    private Colaborador colaborador;
    private String telefoneCandidato;
    private String emailCandidato;
    private String curriculoCandidato;
    private String perfilCandidato;
    private String observacoes;
    private boolean validado;

    // Construtor
    public Indicacao(Long idIndicacao, Vaga vaga, Colaborador colaborador, String telefoneCandidato,
                     String emailCandidato, String curriculoCandidato, String perfilCandidato,
                     String observacoes, boolean validado) {
        this.idIndicacao = idIndicacao;
        this.vaga = vaga;
        this.colaborador = colaborador;
        this.telefoneCandidato = telefoneCandidato;
        this.emailCandidato = emailCandidato;
        this.curriculoCandidato = curriculoCandidato;
        this.perfilCandidato = perfilCandidato;
        this.observacoes = observacoes;
        this.validado = validado;
    }

    // Getters e Setters
    public Long getIdIndicacao() {
        return idIndicacao;
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

    public String getTelefoneCandidato() {
        return telefoneCandidato;
    }

    public void setTelefoneCandidato(String telefoneCandidato) {
        this.telefoneCandidato = telefoneCandidato;
    }

    public String getEmailCandidato() {
        return emailCandidato;
    }

    public void setEmailCandidato(String emailCandidato) {
        this.emailCandidato = emailCandidato;
    }

    public String getCurriculoCandidato() {
        return curriculoCandidato;
    }

    public void setCurriculoCandidato(String curriculoCandidato) {
        this.curriculoCandidato = curriculoCandidato;
    }

    public String getPerfilCandidato() {
        return perfilCandidato;
    }

    public void setPerfilCandidato(String perfilCandidato) {
        this.perfilCandidato = perfilCandidato;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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
        return "Indicacao{" +
                "idIndicacao=" + idIndicacao +
                ", vaga=" + vaga +
                ", colaborador=" + colaborador +
                ", telefoneCandidato='" + telefoneCandidato + '\'' +
                ", emailCandidato='" + emailCandidato + '\'' +
                ", curriculoCandidato='" + curriculoCandidato + '\'' +
                ", perfilCandidato='" + perfilCandidato + '\'' +
                ", observacoes='" + observacoes + '\'' +
                ", validado=" + validado +
                '}';
    }
}
