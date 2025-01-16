package com.desafios.literAlura.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro (
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<DadosAutor> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") int numeroDownloads
){
    @Override
    public String toString() {
        String autores = autores().stream()
                .map(DadosAutor::nome)
                .reduce((a, b) -> a + ", " + b)
                .orElse("Desconhecido");

        return "-------------- Livro ----------------\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + autores + "\n" +
                "Idioma: " + String.join(", ", idiomas) + "\n" +
                "Número de Downloads: " + numeroDownloads + "\n" +
                "--------------------------------------";

    }
}
