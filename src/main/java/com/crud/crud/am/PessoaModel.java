package com.crud.crud.am;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
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
}
