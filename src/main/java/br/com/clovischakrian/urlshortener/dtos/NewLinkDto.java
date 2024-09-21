package br.com.clovischakrian.urlshortener.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewLinkDto {
    @NotBlank(message = "O link a encurtar é uma informação obrigatória.")
    private String link;
}
