package com.example.verodegit.controller;

import com.example.verodegit.dto.Artwork;
import com.example.verodegit.service.ExternalApiService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/artworks")
public class ArtWorkController {

    private final ExternalApiService externalApiService;
    private static final Logger logger = LoggerFactory.getLogger(ArtWorkController.class);


    public ArtWorkController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }
    @CrossOrigin(origins = "http://localhost:3001") // Autoriser uniquement localhost:3001
    @GetMapping
    public List<Artwork> getArtWorks(@RequestParam(required = false) String search){
        return externalApiService.getArtworks(search);
    }
}
