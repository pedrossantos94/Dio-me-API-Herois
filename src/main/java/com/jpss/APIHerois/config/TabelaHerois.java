package com.jpss.APIHerois.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.jpss.APIHerois.constants.ConstantesHeroi.REGION_DYNAMO;
import static com.jpss.APIHerois.constants.ConstantesHeroi.ENDPOINT_DYNAMO;
import java.util.Arrays;

@Configuration
@EnableDynamoDBRepositories
public class TabelaHerois {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client =  AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO)).build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String nomeTabela = "Tabela_Herois_Final";

        try{
            Table table = dynamoDB.createTable(nomeTabela,
                    Arrays.asList(new KeySchemaElement("id", KeyType.HASH)),
                    Arrays.asList(new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L, 5l));
                    table.waitForActive();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
