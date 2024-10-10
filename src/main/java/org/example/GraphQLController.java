package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GraphQLController {

    @Autowired
    private GraphQLService graphQLService;

    @GetMapping("/fetch-data")
    public Mono<String> fetchData() {
        String graphqlQuery = "{ user(id: \"1\") { name email } }"; // Example GraphQL query

        return graphQLService.executeGraphQLQuery(graphqlQuery);
    }
}
