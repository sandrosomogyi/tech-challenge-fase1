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
@Table(name = "tb_Colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaborador;

    private String departamento;
    private String cargo;
    private LocalDate dataContratacao;

    @OneToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    // Construtor Padrão
    public Colaborador() {
    }

    // Construtor com todos os parâmetros
    public Colaborador(Long idColaborador, String departamento, String cargo, LocalDate dataContratacao,
            Pessoa pessoa) {
        this.idColaborador = idColaborador;
        this.departamento = departamento;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
        this.pessoa = pessoa;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Colaborador{" +
                "idColaborador=" + idColaborador +
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
