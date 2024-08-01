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
@Table(name = "tb_Bonificacao")
public class Bonificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_vaga")
    private Vaga vaga;

    @OneToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @OneToOne
    @JoinColumn(name = "id_candidato")
    private Candidato candidato;

    @OneToOne
    @JoinColumn(name = "id_contratacao")
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
