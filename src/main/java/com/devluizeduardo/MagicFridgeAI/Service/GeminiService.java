package com.devluizeduardo.MagicFridgeAI.Service;

import com.devluizeduardo.MagicFridgeAI.Model.FoodItem;
import com.devluizeduardo.MagicFridgeAI.Model.FoodItemDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeminiService {

    private final WebClient webClient;
    private String apiKey = System.getenv("API_KEY");

    public GeminiService(WebClient webClient) {
        this.webClient = webClient;
    }



public Mono<String> generateRecipe(List<FoodItemDTO> foodItemsDto){

        String alimentos = foodItemsDto.stream()
                .map(item ->String.format("%s (%s) - Quantidade: %d, Validade: %s",
                        item.getNome(),item.getCategoria(),item.getQuantidade(),item.getValidade()))
                .collect(Collectors.joining("\n"));
        String prompt="Baseado no meu banco de dados faça uma receita com os seguintes itens: \n " + alimentos;

    Map<String,Object>requestBody = Map.of(
            "contents",List.of(Map.of("parts",
                    List.of(Map.of("text",prompt)))));
    return webClient.post()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .header("x-goog-api-key",apiKey)
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(Map.class)
            .map(response -> {
                var candidates = (List<Map<String, Object>>) response.get("candidates");


                if (candidates != null && !candidates.isEmpty()) {
                    var candidate = candidates.get(0);
                    var content = (Map<String,Object>)candidate.get("content");
                if(content!=null&& !content.isEmpty()){
                    var parts = (List<Map<String, Object>>) content.get("parts");

                    if (parts != null && !parts.isEmpty()) {
                        return parts.get(0).get("text").toString();
                    }
                }}
                return "Nenhuma receita foi gerada";
            });



    }
}
