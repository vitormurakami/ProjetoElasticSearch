package com.microService.projetoElasticSearch.advice;

import com.microService.projetoElasticSearch.exception.PessoaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PessoaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PessoaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pessoaNotFoundHandler(PessoaNotFoundException ex){
        return ex.getMessage();
    }
}
