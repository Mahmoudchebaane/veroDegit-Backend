package com.example.verodegit.service;

import com.example.verodegit.dto.ApiResponse;
import com.example.verodegit.dto.Artwork;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@Service
public class ExternalApiService {

    @Value("${external.api.url}")
    private String externalApiUrl;

    private final WebClient webClient;

    public ExternalApiService(WebClient webClient) {
        this.webClient = webClient;
    }



    public List<Artwork> getArtworks(String query) {

        String URL = externalApiUrl + (query != null ? "/search?q=" + query : "");
        // Utilisation de WebClient pour effectuer un appel GET à l'API externe
        return webClient
                .get()
                .uri(URL)
                .retrieve()
                .bodyToMono(ApiResponse.class) // Récupérer toute la réponse
                .map(ApiResponse::getData)    // Extraire uniquement "data"
                .block();
    }
}
