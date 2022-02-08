package com.microService.projetoPessoa.controller;

import com.microService.projetoPessoa.document.Pessoa;
import com.microService.projetoPessoa.exception.PessoaNotFoundException;
import com.microService.projetoPessoa.repository.PessoaRepository;
import org.apache.el.util.ReflectionUtil;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class PessoaController {
    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pessoas/{id}")
    public Pessoa one(@PathVariable String id){
        return repository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));
    }

    @GetMapping("/pessoas")
    public List<Pessoa> all(){
        List<Pessoa> pessoas = StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
        return pessoas;
    }

    @PostMapping("/pessoas")
    public Pessoa newPessoa(@RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }

    @PutMapping("/pessoas/{id}")
    public Pessoa replacePessoa(@RequestBody Pessoa newPessoa, @PathVariable String id){
        return repository.findById(id).map(pessoa -> {
            pessoa.setNome(newPessoa.getNome());
            pessoa.setIdade(newPessoa.getIdade());
            pessoa.setSexo(newPessoa.getSexo());
            pessoa.setCidadeNascimento(newPessoa.getCidadeNascimento());
            pessoa.setVeiculo(newPessoa.isVeiculo());
            pessoa.setCasa(newPessoa.isCasa());
            return repository.save(pessoa);
        }).orElseGet(() -> {
            newPessoa.setId(id);
            return repository.save(newPessoa);
        });
    }

    @PatchMapping("/pessoas/{id}")
    public @ResponseBody Pessoa partialReplacePessoa(@PathVariable String id, @RequestBody Map<Object, Object> fields){
        Pessoa pessoa = repository.findById(id).orElseThrow(() -> new PessoaNotFoundException(id));

        fields.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Pessoa.class, (String) k);
            field.setAccessible(true);
            ReflectionUtils.setField(field, pessoa, v);
        });
        return repository.save(pessoa);
    }

    @DeleteMapping("/pessoas/{id}")
    public void deletePessoa(@PathVariable String id){
        repository.deleteById(id);
    }







}
