package com.microService.projetoElasticSearch.repository;

import com.microService.projetoElasticSearch.document.Pessoa;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PessoaRepository extends ElasticsearchRepository<Pessoa, String> {
}
