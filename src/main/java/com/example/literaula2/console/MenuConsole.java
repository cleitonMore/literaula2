package com.example.literaula2.console;

import com.example.literaula2.model.Livro;
import com.example.literaula2.service.LivroService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class MenuConsole {

    private final Scanner scanner = new Scanner(System.in);
    private final LivroService livroService;

    public MenuConsole(LivroService livroService) {
        this.livroService = livroService;
    }

    public void iniciar() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU LITERAULA ===");
            System.out.println("1 - Buscar livros na Gutendex");
            System.out.println("2 - Listar livros salvos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> buscarLivros();
                case 2 -> listarSalvos();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida");
            }
        }
    }

    private void buscarLivros() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        List<Livro> livros = livroService.buscarNaGutendex(titulo);

        System.out.println("\n📚 Livros encontrados e salvos:");
        livros.forEach(l ->
                System.out.println("- " + l.getTitulo() + " | " + l.getAutor())
        );
    }

    private void listarSalvos() {
        List<Livro> livros = livroService.listarSalvos();

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro salvo no banco.");
            return;
        }

        System.out.println("\n📖 Livros no banco:");
        livros.forEach(l ->
                System.out.println("- " + l.getTitulo() + " | " + l.getAutor())
        );
    }
}

