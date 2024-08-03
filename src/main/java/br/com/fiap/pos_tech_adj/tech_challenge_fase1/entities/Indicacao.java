package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_indicacao")
public class Indicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_vaga")
    @JsonBackReference(value = "vaga-indicacao")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    @JsonBackReference(value = "colaborador-indicacao")
    private Colaborador colaborador;

    private String telefoneCandidato;
    private String emailCandidato;
    private String curriculoCandidato;
    private String perfilCandidato;
    private String observacoes;
    private boolean validado;

    // Contrutor Padrão
    public Indicacao() {
    }

    // Construtor
    public Indicacao(Long id, Vaga vaga, Colaborador colaborador, String telefoneCandidato,
            String emailCandidato, String curriculoCandidato, String perfilCandidato,
            String observacoes, boolean validado) {
        this.id = id;
        this.vaga = vaga;
        this.colaborador = colaborador;
        this.telefoneCandidato = telefoneCandidato;
        this.emailCandidato = emailCandidato;
        this.curriculoCandidato = curriculoCandidato;
        this.perfilCandidato = perfilCandidato;
        this.observacoes = observacoes;
        this.validado = validado;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Indicacao{" +
                "id=" + id +
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
