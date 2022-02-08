package com.microService.projetoElasticSearch.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "pessoas")
@Setting(settingPath = "static/es-settings.json")
public class Pessoa {

    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Keyword)
    private String nome;

    @Field(type = FieldType.Integer)
    private int idade;

    @Field(type = FieldType.Keyword)
    private String sexo;

    @Field(type = FieldType.Keyword)
    private String cidadeNascimento;

    @Field(type = FieldType.Boolean)
    private boolean veiculo;

    @Field(type = FieldType.Boolean)
    private boolean casa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCidadeNascimento() {
        return cidadeNascimento;
    }

    public void setCidadeNascimento(String cidadeNascimento) {
        this.cidadeNascimento = cidadeNascimento;
    }

    public boolean isVeiculo() {
        return veiculo;
    }

    public void setVeiculo(boolean veiculo) {
        this.veiculo = veiculo;
    }

    public boolean isCasa() {
        return casa;
    }

    public void setCasa(boolean casa) {
        this.casa = casa;
    }


}
