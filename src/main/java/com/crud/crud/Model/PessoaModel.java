package com.crud.crud.Model;

import jakarta.persistence.*;

@Entity(name = "pessoa")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long codigo;

    @Column(nullable = false, length = 60)
    public String nome;

    @Column(nullable = false, length = 4)
    public Integer idade;

    @Column(nullable = false, length = 100)
    public String email;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
