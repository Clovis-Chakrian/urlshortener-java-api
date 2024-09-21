package br.com.clovischakrian.urlshortener.services;

import br.com.clovischakrian.urlshortener.dtos.NewLinkDto;
import br.com.clovischakrian.urlshortener.entities.Link;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ILinkService {
    public List<Link> getAllLinks();
    public Optional<Link> getLinkById(int id);
    public Link insertLink(NewLinkDto newLinkDto);
    public Link updateLink(int id);
    public boolean removeLink(int id);
}
