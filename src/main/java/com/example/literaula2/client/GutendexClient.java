package com.example.literaula2.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GutendexClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonNode buscarLivros(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo;
        String json = restTemplate.getForObject(url, String.class);

        try {
            return mapper.readTree(json);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler JSON da Gutendex", e);
        }
    }
}

