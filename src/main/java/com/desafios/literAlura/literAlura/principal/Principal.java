package com.desafios.literAlura.literAlura.principal;

import com.desafios.literAlura.literAlura.model.*;
import com.desafios.literAlura.literAlura.service.ConsumoApi;
import com.desafios.literAlura.literAlura.service.ConverteDados;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private ConverteDados converteDados = new ConverteDados();


    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 0){
            var menu = """
                    ----------------------
                    Escolha o número de sua opção:
                    1 - buscar livro pelo título
                    2 - listar livros registrados
                    3 - listar autores registrados
                    4 - listar autores vivos em um determinado ano
                    5 - listar livros em um determinado idioma
                    0 - sair
                    ------------------------""";

            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    buscarLivroApi();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosNoAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
    public void buscarLivroApi(){
        System.out.println("Digite o título do livro: ");
        var titulo = scanner.nextLine();
        var json = consumo.obterDados(ENDERECO + titulo.replace(" ", "%20"));
        System.out.println(json);

        ApiResponse dados = converteDados.obterDados(json, ApiResponse.class);

        if (dados.results() == null || dados.results().isEmpty()){
            System.out.println("Nenhum livro encontrado");
            return;
        }
        for (DadosLivro livro : dados.results()) {
            System.out.println("------------------------");
            System.out.println("Título: " + livro.titulo());
            System.out.println("Autor: " + livro.autores().stream().map(DadosAutor::nome).collect(Collectors.joining(", ")));
            System.out.println("Idioma: " + livro.idiomas().get(0));
            System.out.println("Número de downloads: " + livro.numeroDownloads());
            System.out.println("------------------------");
        }
    }
    public void listarLivrosRegistrados(){}
    public void listarAutoresRegistrados(){}
    public void listarAutoresVivosNoAno(){}
    public void listarLivrosPorIdioma(){}
}
