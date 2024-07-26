package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

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
    public Colaborador(Long idColaborador, String departamento, String cargo, LocalDate dataContratacao, Pessoa pessoa) {
        this.idColaborador = idColaborador;
        this.departamento = departamento;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
        this.pessoa = pessoa;
    }

    // Getters
    public Long getIdColaborador() {
        return idColaborador;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
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
