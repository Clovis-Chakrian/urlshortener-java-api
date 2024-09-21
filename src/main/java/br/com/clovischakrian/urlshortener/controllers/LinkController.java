package br.com.clovischakrian.urlshortener.controllers;

import br.com.clovischakrian.urlshortener.dtos.LinkDto;
import br.com.clovischakrian.urlshortener.entities.Link;
import br.com.clovischakrian.urlshortener.services.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Link> redirectById(@PathVariable int id, HttpServletResponse httpResponse) throws IOException {
        Optional<Link> link = linkService.getLinkById(id);

        if (link.isEmpty()) ResponseEntity.notFound();

        httpResponse.sendRedirect(link.get().getRedirectLink());
        return null;
    }

    @PostMapping
    public ResponseEntity<Link> insertLink(@Valid @RequestBody LinkDto linkDto) {
        Link link = linkService.insertLink(linkDto);
        return new ResponseEntity<>(link, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Link> updateLink(@PathVariable int id, @Valid @RequestBody LinkDto linkDto) {
        Optional<Link> link = linkService.updateLink(linkDto, id);

        if (link.isEmpty()) ResponseEntity.notFound();

        return new ResponseEntity<>(link.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeLink(@PathVariable int id) {
        boolean link = linkService.removeLink(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
