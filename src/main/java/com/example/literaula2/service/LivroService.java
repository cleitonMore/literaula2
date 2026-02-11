package com.example.literaula2.service;

import com.example.literaula2.model.Livro;
import com.example.literaula2.repository.LivroRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> buscarNaGutendex(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo;

        String json = restTemplate.getForObject(url, String.class);

        List<Livro> livros = new ArrayList<>();

        try {
            JsonNode root = mapper.readTree(json);
            JsonNode results = root.get("results");

            for (JsonNode item : results) {
                Livro livro = new Livro();

                livro.setTitulo(item.get("title").asText());

                // autor (pega o primeiro)
                JsonNode authors = item.get("authors");
                if (authors.isArray() && authors.size() > 0) {
                    livro.setAutor(authors.get(0).get("name").asText());
                }

                // idioma
                JsonNode languages = item.get("languages");
                if (languages.isArray() && languages.size() > 0) {
                    livro.setIdioma(languages.get(0).asText());
                }

                livros.add(livro);
            }

            // salva no banco
            return repository.saveAll(livros);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar resposta da Gutendex", e);
        }
    }

    public List<Livro> listarSalvos() {
        return repository.findAll();
    }
}



