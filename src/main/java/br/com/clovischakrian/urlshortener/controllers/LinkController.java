package br.com.clovischakrian.urlshortener.controllers;

import br.com.clovischakrian.urlshortener.dtos.NewLinkDto;
import br.com.clovischakrian.urlshortener.entities.Link;
import br.com.clovischakrian.urlshortener.repositories.LinkRepository;
import br.com.clovischakrian.urlshortener.services.ILinkService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/links")
public class LinkController {
    @Autowired
    ILinkService linkService;

    @GetMapping
    public ResponseEntity<List<Link>> obterLinks() {
        List<Link> links = linkService.getAllLinks();
        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Link> insertLink(@Valid @RequestBody NewLinkDto newLinkDto) {
        Link link = linkService.insertLink(newLinkDto);
        return new ResponseEntity<>(link, HttpStatus.CREATED);
    }
}
