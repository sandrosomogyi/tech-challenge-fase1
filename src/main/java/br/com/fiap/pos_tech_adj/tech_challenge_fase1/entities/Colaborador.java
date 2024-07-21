package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_Colaborador")
public class Colaborador extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaborador;

    //Contrutor Padrão
    public Colaborador(){
    }

    // Construtor
    public Colaborador(Long idColaborador, String nome, String sobrenome, String telefone, String email) {
        super(nome, sobrenome, telefone, email);
        this.idColaborador = idColaborador;
    }

    // Getters
    public Long getIdColaborador() {
        return idColaborador;
    }

    // toString para facilitar a visualização
    @Override
    public String toString() {
        return "Colaborador{" +
                "idColaborador=" + idColaborador +
                ", nome='" + getNome() + '\'' +
                ", sobrenome='" + getSobrenome() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", email='" + getEmail() + '\'' +
                '}';
    }
}