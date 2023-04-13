package com.crud.crud.as;

import com.crud.crud.ae.RequestException;
import com.crud.crud.am.PessoaModel;
import com.crud.crud.ar.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    public PessoaRepository repository;

    public List<PessoaModel> listar(){
        return repository.findAll();
    }

    public List<PessoaModel> listarPorOrdemAlfabetica(){
        return repository.listarPorOrdemAlfabetica();
    }

    public List<PessoaModel> listarPorIdade(){
        return repository.listarPorIdade();
    }

    public PessoaModel buscarPorID(Long codigo){
        return isPersonByCode(codigo);
    }

    public List<PessoaModel> buscrPortrecho(String trecho){
        return repository.buscarPorParte(trecho);
    }

    public String salvar(PessoaModel pessoa){
        for(PessoaModel person: repository.findAll())
            if(person.getEmail().equals(pessoa.getEmail()) && pessoa.getCodigo() == null)
                throw new RequestException("O email digitado já é utilizado, por favor digite outro!");

        repository.save(pessoa);
        return "USuário salvo com sucesso!";
    }

    public String excluirPorID(@RequestParam (name = "codigo") Long codigo){
        isPersonByCode(codigo);
        repository.deleteById(codigo);
        return "Usuário excluiudo com sucesso!";
    }

    //validações
    public PessoaModel isPersonByCode(Long codigo){
        Optional<PessoaModel> pessoa = repository.buscaPorID(codigo);
        if(pessoa.isEmpty()) throw new RequestException("Usuário inexistente");
        else return pessoa.get();
    }
}
