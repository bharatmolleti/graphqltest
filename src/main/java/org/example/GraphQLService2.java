package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class GraphQLService2 {

    private final WebClient webClient;

    @Autowired
    public GraphQLService2(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://countries.trevorblades.com").build();
    }

    public Mono<String> executeGraphQLQuery(String graphqlQuery) {
        // Build the request body as a Map to ensure correct JSON formatting
        Map<String, Object> body = new HashMap<>();
        body.put("query", graphqlQuery);

        return webClient.post()
                //.uri("/graphql")
                .uri("/")  // Use the base URL directly, no need for additional paths
                .contentType(MediaType.APPLICATION_JSON)
                //.bodyValue("{ \"query\": \"" + graphqlQuery + "\" }")
                .bodyValue(body)  // Send the body as JSON
                .retrieve()
                .bodyToMono(String.class);
    }
}
