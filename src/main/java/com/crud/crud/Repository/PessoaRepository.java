package com.crud.crud.Repository;

import com.crud.crud.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    @Query(value = "select * from pessoa where codigo = ?", nativeQuery = true)
    public PessoaModel buscaPorID(Long codigo);

    @Query(value = "select * from pessoa where nome like %?%", nativeQuery = true)
    public List<PessoaModel> buscarPorParte(String nome);

    @Query(value = "select * from pessoa order by nome asc", nativeQuery = true)
    public List<PessoaModel> listarPorOrdemAlfabetica();

    @Query(value = "select * from pessoa order by idade asc", nativeQuery = true)
    public List<PessoaModel> listarPorIdade();

}
