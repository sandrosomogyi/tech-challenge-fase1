package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_candidato")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    private String perfilLinkedin;
    private String curriculo;

    @OneToOne
    @JoinColumn(name="id_colaborador")
    private Colaborador colaborador;


    // Contrutor Padrão
    public Candidato() {
    }

    public Candidato(Long id, Pessoa pessoa, String perfilLinkedin, String curriculo,  Colaborador colaborador) {
        this.id = id;
        this.pessoa = pessoa;
        this.perfilLinkedin = perfilLinkedin;
        this.curriculo = curriculo;
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "id=" + id +
                ", pessoa=" + pessoa +
                ", perfilLinkedin='" + perfilLinkedin + '\'' +
                ", curriculo='" + curriculo + '\'' +
                ", colaborador=" + colaborador +
                '}';
    }
}
