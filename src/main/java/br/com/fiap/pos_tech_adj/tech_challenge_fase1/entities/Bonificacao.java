package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_bonificacao")
public class Bonificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_vaga")
    @JsonBackReference(value = "vaga-bonificacao")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    @JsonBackReference(value = "colaborador-bonificacao")
    private Colaborador colaborador;

    @OneToOne
    @JoinColumn(name = "id_candidato")
    @JsonBackReference(value = "candidato-bonificacao")
    private Candidato candidato;

    @OneToOne
    @JoinColumn(name = "id_contratacao")
    @JsonBackReference(value = "contratacao-bonificacao")
    private Contratacao contratacao;

    private LocalDate dataBonificacao;
    private boolean efetuada;

    // Contrutor Padrão
    public Bonificacao() {
    }

    // Construtor
    public Bonificacao(Long id, Vaga vaga, Colaborador colaborador, Candidato candidato,
            Contratacao contratacao, LocalDate dataBonificacao, boolean efetuada) {
        this.id = id;
        this.vaga = vaga;
        this.colaborador = colaborador;
        this.candidato = candidato;
        this.contratacao = contratacao;
        this.dataBonificacao = dataBonificacao;
        this.efetuada = efetuada;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Bonificacao{" +
                "id=" + id +
                ", vaga=" + vaga +
                ", colaborador=" + colaborador +
                ", candidato=" + candidato +
                ", contratacao=" + contratacao +
                ", dataBonificacao=" + dataBonificacao +
                ", efetuada=" + efetuada +
                '}';
    }
}
