package com.desafios.literAlura.literAlura.model;

import java.util.List;

public record ApiResponse(int count,
                          String next,
                          String previous,
                          List<DadosLivro> results) {
}
