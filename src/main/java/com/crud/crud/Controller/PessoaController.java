package com.crud.crud.Controller;

import com.crud.crud.Model.PessoaModel;
import com.crud.crud.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {

    @Autowired
    public PessoaRepository repository;

    @GetMapping(value = "listar")
    public List<PessoaModel> listar(){
        return repository.findAll();
    }

    @GetMapping(value = "listarPorOrdemAlfabetica")
    public List<PessoaModel> listarPorOrdem(){
        return repository.listarPorOrdemAlfabetica();
    }

    @GetMapping(value = "listarPorIdade")
    public List<PessoaModel> listarPorIdade(){
        return repository.listarPorIdade();
    }

    @GetMapping(value = "buscarPorID")
    public PessoaModel buscarPorID(@RequestParam (name = "codigo") Long codigo){
        return repository.buscaPorID(codigo);
    }

    @GetMapping(value = "buscarPorParte")
    public List<PessoaModel> buscrPorParte(@RequestParam (name = "nome") String nome){
        return repository.buscarPorParte(nome);
    }

    @PostMapping(value = "salvar")
    public void salvar(@RequestBody PessoaModel pessoa){
        repository.save(pessoa);
    }

    @DeleteMapping(value = "deletar")
    public  void deletar(@RequestParam (name = "codigo") Long codigo){
        repository.deleteById(codigo);
    }
}
