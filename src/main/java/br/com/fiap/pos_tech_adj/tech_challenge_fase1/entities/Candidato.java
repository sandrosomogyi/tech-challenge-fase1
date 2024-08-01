package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

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
@Table(name = "tb_Candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    private String perfilLinkedin;
    private String curriculo;

    // Contrutor Padrão
    public Candidato() {
    }

    // Construtor
    public Candidato(Long id, Pessoa pessoa, String perfilLinkedin, String curriculo) {
        this.id = id;
        this.pessoa = pessoa;
        this.perfilLinkedin = perfilLinkedin;
        this.curriculo = curriculo;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", nome='" + pessoa.getNome() + '\'' +
                ", sobrenome='" + pessoa.getSobrenome() + '\'' +
                ", telefone='" + pessoa.getTelefone() + '\'' +
                ", email='" + pessoa.getEmail() + '\'' +
                ", perfilLinkedin='" + perfilLinkedin + '\'' +
                ", curriculo='" + curriculo + '\'' +
                '}';
    }
}
