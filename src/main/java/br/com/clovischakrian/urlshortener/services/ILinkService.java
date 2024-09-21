package br.com.clovischakrian.urlshortener.services;

import br.com.clovischakrian.urlshortener.dtos.LinkDto;
import br.com.clovischakrian.urlshortener.entities.Link;

import java.util.List;
import java.util.Optional;

public interface ILinkService {
    public List<Link> getAllLinks();
    public Optional<Link> getLinkById(int id);
    public Link insertLink(LinkDto linkDto);
    public Optional<Link> updateLink(LinkDto linkDto, int id);
    public boolean removeLink(int id);
}
