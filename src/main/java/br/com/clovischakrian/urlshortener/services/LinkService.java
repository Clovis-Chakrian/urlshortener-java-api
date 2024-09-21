package br.com.clovischakrian.urlshortener.services;

import br.com.clovischakrian.urlshortener.dtos.LinkDto;
import br.com.clovischakrian.urlshortener.entities.Link;
import br.com.clovischakrian.urlshortener.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService implements ILinkService {
    @Autowired
    private LinkRepository linkRepository;

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.getAll();
    }

    @Override
    public Optional<Link> getLinkById(int id) {
        return linkRepository.getByLinkId(id);
    }

    @Override
    public Link insertLink(LinkDto linkDto) {
        Link l = new Link();
        l.setRedirectLink(linkDto.getLink());
        linkRepository.save(l);

        return l;
    }

    @Override
    public Optional<Link> updateLink(LinkDto linkDto, int id) {
        Optional<Link> link = linkRepository.getByLinkId(id);

        if (link.isEmpty()) return link;

        link.get().setRedirectLink(linkDto.getLink());
        linkRepository.save(link.get());

        return link;
    }

    @Override
    public boolean removeLink(int id) {
        return false;
    }
}
