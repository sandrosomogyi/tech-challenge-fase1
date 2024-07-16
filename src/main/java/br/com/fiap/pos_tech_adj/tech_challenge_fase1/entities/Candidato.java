package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Candidato")
public class Candidato extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidato;
    private String perfilLinkedin;
    private String curriculo;

    // Construtor
    public Candidato(Long idCandidato, String nome, String sobrenome, String telefone, String email, String perfilLinkedin, String curriculo) {
        super(nome, sobrenome, telefone, email);
        this.idCandidato = idCandidato;
        this.perfilLinkedin = perfilLinkedin;
        this.curriculo = curriculo;
    }

    // Getters e Setters
    public Long getIdCandidato() {
        return idCandidato;
    }

    public String getPerfilLinkedin() {
        return perfilLinkedin;
    }

    public void setPerfilLinkedin(String perfilLinkedin) {
        this.perfilLinkedin = perfilLinkedin;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Candidato{" +
                "idCandidato=" + idCandidato +
                ", nome='" + getNome() + '\'' +
                ", sobrenome='" + getSobrenome() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", perfilLinkedin='" + perfilLinkedin + '\'' +
                ", curriculo='" + curriculo + '\'' +
                '}';
    }
}
