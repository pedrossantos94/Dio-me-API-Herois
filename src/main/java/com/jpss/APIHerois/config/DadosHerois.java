package com.jpss.APIHerois.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.jpss.APIHerois.constants.ConstantesHeroi.REGION_DYNAMO;
import static com.jpss.APIHerois.constants.ConstantesHeroi.ENDPOINT_DYNAMO;

public class DadosHerois {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Tabela_Herois_Final");
        Item heroi = new Item()
                .withPrimaryKey("id",1)
                .withString("nome", "Homem Aranha")
                .withString("universo","Marvel")
                .withNumber("filmes",1);

        PutItemOutcome outcome = table.putItem(heroi);
    }
}
