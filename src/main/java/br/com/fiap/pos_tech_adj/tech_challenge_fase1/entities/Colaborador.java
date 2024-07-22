package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_Colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaborador;

    @OneToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    //Contrutor Padrão
    public Colaborador(){
    }

    // Construtor
    public Colaborador(Long idColaborador, Pessoa pessoa) {
        this.idColaborador = idColaborador;
        this.pessoa = pessoa;
    }

    // Getters
    public Long getIdColaborador() {
        return idColaborador;
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
                ", nome='" + pessoa.getNome() + '\'' +
                ", sobrenome='" + pessoa.getSobrenome() + '\'' +
                ", telefone='" + pessoa.getTelefone() + '\'' +
                ", email='" + pessoa.getEmail() + '\'' +
                '}';
    }
}