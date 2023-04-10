package com.crud.crud.Controller;

import com.crud.crud.Model.PessoaModel;
import com.crud.crud.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    public PessoaService service;


    @GetMapping
    public List<PessoaModel> listar(){
        return service.listar();
    }

    @GetMapping(path = "/ordemAlfabetica")
    public List<PessoaModel> listarPorOrdem(){
        return service.listarPorOrdemAlfabetica();
    }

    @GetMapping(value = "/ordemIdade")
    public List<PessoaModel> listarPorIdade(){
        return service.listarPorIdade();
    }

    @GetMapping(path = "/trecho/{trecho}")
    public List<PessoaModel> buscrPorParte(@PathVariable String trecho){
        return service.buscrPortrecho(trecho);
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<?> buscarPorID(@PathVariable Long codigo){
        return new ResponseEntity<>(service.buscarPorID(codigo), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody PessoaModel pessoa){
        return  new ResponseEntity<>(service.salvar(pessoa), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{codigo}")
    public ResponseEntity<?> deletar(@PathVariable Long codigo){
        return  new ResponseEntity<>(service.excluirPorID(codigo), HttpStatus.OK);
    }
}
