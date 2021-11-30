package com.jpss.APIHerois.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "Tabela_Herois_Final")

public class Heroi {
    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;
    @DynamoDBAttribute(attributeName = "nome")
    private String nome;
    @DynamoDBAttribute(attributeName = "universo")
    private String universo;
    @DynamoDBAttribute(attributeName = "filmes")
    private int filmes;

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

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }

    public int getFilmes() {
        return filmes;
    }

    public void setFilmes(int filmes) {
        this.filmes = filmes;
    }

    public Heroi (String id, String nome, String universo, int filmes){
        this.id = id;
        this.nome = nome;
        this.universo = universo;
        this.filmes = filmes;
    }
}
