package com.crud.crud.controller;

import com.crud.crud.model.PessoaModel;
import com.crud.crud.service.PessoaService;
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
    public ResponseEntity<?> listar(){
        return  new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping(path = "/ordemAlfabetica")
    public ResponseEntity<?> listarPorOrdem(){
        return  new ResponseEntity<>(service.listarPorOrdemAlfabetica(), HttpStatus.OK);
    }

    @GetMapping(value = "/ordemIdade")
    public ResponseEntity<?> listarPorIdade(){
        return  new ResponseEntity<>(service.listarPorIdade(), HttpStatus.OK);
    }

    @GetMapping(path = "/trecho/{trecho}")
    public ResponseEntity<?> buscrPorParte(@PathVariable String trecho){
        return  new ResponseEntity<>(service.buscrPortrecho(trecho), HttpStatus.OK);
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
