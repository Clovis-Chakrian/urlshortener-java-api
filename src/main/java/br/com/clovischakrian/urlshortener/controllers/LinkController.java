package br.com.clovischakrian.urlshortener.controllers;

import br.com.clovischakrian.urlshortener.entities.Link;
import br.com.clovischakrian.urlshortener.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/links")
public class LinkController {
    @Autowired
    LinkRepository linkRepository;

    @GetMapping
    public ResponseEntity<List<Link>> obterLinks() {
        List<Link> links = linkRepository.getAll();
        return new ResponseEntity<>(links, HttpStatus.OK);
    }
}
