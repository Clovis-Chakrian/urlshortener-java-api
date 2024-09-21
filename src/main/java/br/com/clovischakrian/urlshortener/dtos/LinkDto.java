package br.com.clovischakrian.urlshortener.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkDto {
    @Valid
    @NotBlank(message = "O link a encurtar é uma informação obrigatória.")
    private String link;
}
