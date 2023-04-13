package com.crud.crud.ar;

import com.crud.crud.am.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    @Query(value = "select * from pessoa where codigo = ?", nativeQuery = true)
    public Optional<PessoaModel> buscaPorID(Long codigo);

    @Query(value = "select * from pessoa where nome like %?%", nativeQuery = true)
    public List<PessoaModel> buscarPorParte(String nome);

    @Query(value = "select * from pessoa order by nome asc", nativeQuery = true)
    public List<PessoaModel> listarPorOrdemAlfabetica();

    @Query(value = "select * from pessoa order by idade asc", nativeQuery = true)
    public List<PessoaModel> listarPorIdade();

}
