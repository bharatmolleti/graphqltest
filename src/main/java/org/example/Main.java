package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private GraphQLService graphQLService;

    @Autowired
    private GraphQLService2 graphQLService2;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Define GraphQL endpoint and query
        //String graphqlEndpoint = "https://your-graphql-endpoint.com/graphql";
        //String graphqlQuery = "{ user(id: \"1\") { name, email } }"; // Example query
        // Define the GraphQL query
        //String graphqlQuery = "{ countries { code name capital } }"; // Query for countries
        // Define the GraphQL query to get data for the country with code "AE"
        //String graphqlQuery = "{ country(code: \"AE\") { code name capital } }";


        // Call the GraphQLService using RestTemplate
        // String response = graphQLService.executeGraphQLQuery(graphqlEndpoint, graphqlQuery);
        // System.out.println("GraphQL Response (RestTemplate): " + response);

        // OR call the GraphQLService using WebClient (Recommended for reactive applications)
        //Mono<String> responseMono = graphQLService.executeGraphQLQuery(graphqlQuery);
        //responseMono.subscribe(response -> System.out.println("GraphQL Response (WebClient): " + response));

        System.out.println("Generic Query");
        queryGeneric();

        System.out.println("Specific Query");
        querySpecific();

        System.out.println("Error Query");
        queryError();
    }

    private void queryGeneric() {
        // Define the GraphQL query
        String graphqlQuery = "{ countries { code name capital } }"; // Query for countries

        Mono<String> responseMono = graphQLService.executeGraphQLQuery(graphqlQuery);
        responseMono.subscribe(response -> System.out.println("queryGeneric- GraphQL Response (WebClient): " + response));
    }

    private void querySpecific() {
        // Define the GraphQL query to get data for the country with code "AE"
        String graphqlQuery = "{ country(code: \"AE\") { code name capital } }";

        // OR call the GraphQLService using WebClient (Recommended for reactive applications)
        Mono<String> responseMono = graphQLService2.executeGraphQLQuery(graphqlQuery);
        responseMono.subscribe(response -> System.out.println("querySpecific - GraphQL Response (WebClient): " + response));
    }

    private void queryError() {
        // Define the GraphQL query to get data for the country with code "AE"
        String graphqlQuery = "{ country(code: \"AE\") { code name capital } }";

        // OR call the GraphQLService using WebClient (Recommended for reactive applications)
        Mono<String> responseMono = graphQLService.executeGraphQLQuery(graphqlQuery);
        responseMono.subscribe(response -> System.out.println("queryError - GraphQL Response (WebClient): " + response));
    }
}
