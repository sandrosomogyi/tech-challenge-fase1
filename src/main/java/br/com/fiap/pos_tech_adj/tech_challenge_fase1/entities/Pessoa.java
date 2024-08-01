package br.com.fiap.pos_tech_adj.tech_challenge_fase1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String telefone;
    private String email;

    // Contrutor Padrão
    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String sobrenome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
    }
}
