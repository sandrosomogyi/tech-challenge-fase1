package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departamento;
    private String cargo;
    private LocalDate dataContratacao;

    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @OneToMany(mappedBy = "colaborador")
    @JsonManagedReference(value = "colaborador-indicacao")
    private List<Indicacao> indicacoes;

    @OneToMany(mappedBy = "colaborador")
    @JsonManagedReference(value = "colaborador-bonificacao")
    private List<Bonificacao> bonificacoes;

    // Construtor Padrão
    public Colaborador() {
    }

    // Construtor com todos os parâmetros
    public Colaborador(Long id, String departamento, String cargo, LocalDate dataContratacao,
            Pessoa pessoa, List<Indicacao> indicacoes, List<Bonificacao> bonificacoes) {
        this.id = id;
        this.departamento = departamento;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
        this.pessoa = pessoa;
        this.indicacoes = indicacoes;
        this.bonificacoes = bonificacoes;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Colaborador{" +
                "id=" + id +
                ", departamento='" + departamento + '\'' +
                ", cargo='" + cargo + '\'' +
                ", dataContratacao=" + dataContratacao +
                ", nome='" + pessoa.getNome() + '\'' +
                ", sobrenome='" + pessoa.getSobrenome() + '\'' +
                ", telefone='" + pessoa.getTelefone() + '\'' +
                ", email='" + pessoa.getEmail() + '\'' +
                '}';
    }
}
