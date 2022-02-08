package com.microService.projetoPessoa.exception;

public class PessoaNotFoundException extends RuntimeException{
    public PessoaNotFoundException(String id){
        super("Não foi possível encontrar a pessoa " + id);
    }
}
