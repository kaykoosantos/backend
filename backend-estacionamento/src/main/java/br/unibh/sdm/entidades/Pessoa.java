package br.unibh.sdm.entidades;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Pessoa")
public class Pessoa {

    private String nome;
    private String cpf;
    private String rg;
    private String telefone;

    public Pessoa(String nome2, int idade) {
        // Construtor padrão necessário para o DynamoDBMapper
    }

    public Pessoa(String nome, String cpf, String rg, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
    }

    @DynamoDBHashKey(attributeName = "Cpf")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @DynamoDBAttribute(attributeName = "Nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @DynamoDBAttribute(attributeName = "Rg")
    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @DynamoDBAttribute(attributeName = "Telefone")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone + "]";
    }

    // Implementações de equals e hashCode conforme necessário para DynamoDB
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Pessoa pessoa = (Pessoa) obj;

        if (!cpf.equals(pessoa.cpf))
            return false;
        if (!nome.equals(pessoa.nome))
            return false;
        if (!rg.equals(pessoa.rg))
            return false;
        return telefone.equals(pessoa.telefone);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }
}
