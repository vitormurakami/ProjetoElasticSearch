package com.microService.projetoPessoa.repository;

import com.microService.projetoPessoa.document.Pessoa;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface PessoaRepository extends ElasticsearchRepository<Pessoa, String> {
}
