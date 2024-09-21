package br.com.clovischakrian.urlshortener.controllers;

import java.util.List;

public record ApiError(String mensagem, List<String> erros) {
}
