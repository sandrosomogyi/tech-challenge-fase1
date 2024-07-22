package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_Candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidato;

    @OneToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    private String perfilLinkedin;
    private String curriculo;

    //Contrutor Padrão
    public Candidato(){
    }

    // Construtor
    public Candidato(Long idCandidato, Pessoa pessoa, String perfilLinkedin, String curriculo) {
        this.idCandidato = idCandidato;
        this.pessoa = pessoa;
        this.perfilLinkedin = perfilLinkedin;
        this.curriculo = curriculo;
    }

    // Getters e Setters
    public Long getIdCandidato() {
        return idCandidato;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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

    @Override
    public String toString() {
        return "Candidato{" +
                "idCandidato=" + idCandidato +
                ", nome='" + pessoa.getNome() + '\'' +
                ", sobrenome='" + pessoa.getSobrenome() + '\'' +
                ", telefone='" + pessoa.getTelefone() + '\'' +
                ", email='" + pessoa.getEmail() + '\'' +
                ", perfilLinkedin='" + perfilLinkedin + '\'' +
                ", curriculo='" + curriculo + '\'' +
                '}';
    }
}
